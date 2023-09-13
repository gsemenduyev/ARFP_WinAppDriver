class RfpDetailsPage {
    rfpStatus(milliseconds) {
        return cy.get("a[href='#']").eq(5, { timeout: milliseconds });
    }
    pageTitle(milliseconds) {
        return cy.get('#page-title', { timeout: milliseconds });
    }
    launchPreBuyButton(milliseconds) {
        return cy.get('.btn-link', { timeout: milliseconds });
    }
    responseButton(milliseconds) {
        return cy.get("[ng-show='!request.$hideResponses'] a", { timeout: milliseconds });
    }
}
export default RfpDetailsPage;