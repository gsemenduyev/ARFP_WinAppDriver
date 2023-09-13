/// <reference types="Cypress" />
/// <reference types="cypress-data-session" />
/// <reference types="cypress-iframe" />
import 'cypress-data-session';
import 'cypress-iframe';
import { Given } from "@badeball/cypress-cucumber-preprocessor";
import LinearProposalRfpPage from "../../../support/page-objects/agency-pages/LinearProposalRfpPage";
import MailinatorHomePage from "../../../support/page-objects/mailinator-pages/MailinatorHomePage";

const linearProposalRfpPage = new LinearProposalRfpPage;
const mailinatorHomePage = new MailinatorHomePage;

const SELLER_NEGOTIATION_RATE = '9';

let newRfpParam;

before(function () {
    cy.fixture('/agencyRFP/new-rfp-param').then(function (data) {
        newRfpParam = data;
    })
})

// Change My Rete and Negotiate the line with seller
Given('Change My Rete {string} and Negotiate the line with seller', myRate => {
    linearProposalRfpPage.selectLineCheckBox().first().check({ force: true });
    linearProposalRfpPage.myReteTexBox().type(myRate + '{enter}');
    linearProposalRfpPage.saveButton().click();
    cy.window().then(() => {
        linearProposalRfpPage.alertBox().should('have.text', 'Success! Your data has been saved.');
    });
    linearProposalRfpPage.myReteTexBoxValue().should('have.text', '$ ' + myRate);
    linearProposalRfpPage.selectLineCheckBox().first().check({ force: true });
    linearProposalRfpPage.negotiateButton().click({ force: true });
    linearProposalRfpPage.sendSelectedBuylinesModal().should('exist');
    linearProposalRfpPage.sendSelectedBuylinesModalTitle().should('have.text', 'Send Selected Buylines');
    linearProposalRfpPage.sendSelectedBuylinesModalMyRate(myRate).should('have.text', '$ ' + myRate);
    linearProposalRfpPage.sendButton().click();
    cy.window().then(() => {
        linearProposalRfpPage.alertBox().should('have.text', 'Negotiation successfully sent to ' + newRfpParam.vendor.substr(0, newRfpParam.vendor.indexOf('-')));
    });
});

// "Accept, Reject, Make Changes" negotiation from email and verify user landed on Stratasphere page
Given('{string} negotiation from email and verify user landed on Stratasphere page', negotiate => {
    cy.dataSession('newRfpName').then(newRfpName => {
        mailinatorHomePage.search_email('New Change Request for ', newRfpName);
    })
    mailinatorHomePage.negotiationLinks(negotiate).then(function (el) {
        const url = el.prop('href');
        mailinatorHomePage.deleteEmailButton().click();
        cy.visit(url);
        const sentArgs = { negotiate, sellerNegotiationRate: SELLER_NEGOTIATION_RATE };
        cy.origin(url, { args: sentArgs }, ({ negotiate, sellerNegotiationRate }) => {
            const tempPage = Cypress.require('../../../support/page-objects/ssphere-pages/SSphereBasePage');
            const sSphereBasePage = new tempPage;
            sSphereBasePage.pageTitle().should('include.text', 'Proposal Response ' + negotiate);
            if (negotiate === "Make Changes") {
                sSphereBasePage.myRateNegotiation().type(sellerNegotiationRate);
                sSphereBasePage.submitButton().click();
            }
            sSphereBasePage.negotiationMessage().should('include.text', 'Your response has been sent. Thanks for using Stratasphere!');
        });
    });
});

// Validate line changes were "accepted, rejected, " by the Seller
Given('Validate line changes were {string} by the Seller', negotiate => {
    if (negotiate === 'Make Changes') {
        linearProposalRfpPage.sellerRateTexBoxValue().should('include.text', SELLER_NEGOTIATION_RATE);
    } else {
        linearProposalRfpPage.actionsDropdown().click({ force: true });
        linearProposalRfpPage.msgAndAttachmentsOption().click();
        linearProposalRfpPage.lineChangesMsg().should('include.text', negotiate);
        linearProposalRfpPage.msgSidebarCloseButton().click();

        if (negotiate === 'accepted') {
            linearProposalRfpPage.myReteTexBoxValue().then(function (myRete) {
                linearProposalRfpPage.sellerRateTexBoxValue().should('include.text', myRete.text());
            });
        } else if (negotiate === 'rejected') {
            linearProposalRfpPage.myReteTexBoxValue().then(function (myRete) {
                linearProposalRfpPage.sellerRateTexBoxValue().should('not.eq', myRete.text());
            });
        }
    }
});