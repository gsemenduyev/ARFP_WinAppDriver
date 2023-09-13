@Stratasphere @ARFP
Feature: Messaging between Seller and Buyer

  Feature Description: Validate messaging between Seller and Buyer

  Scenario: Buyer creates new RFP and send it to Seller (MBSB)
    * Login to Agency RFP with 'Permanent' password
    * Create New RFP
    * Validate RFP Creation
    * Logout Agency RFP

  Scenario: Seller Validates RFP Details Page and sends a message to buyer (MBSB)
    * Login to Stratasphere
    * Search for RFP in Stratasphere
    * Validate "RFP Details" Page in Stratasphere
    * Send a message from Seller to Buyer
    * Logout from Stratasphere

  Scenario: Buyer Validates RFP Details Page and sends a message to Buyer (MBSB)
    * Login to Agency RFP with 'Permanent' password
    * Search for existing RFP
    * Click on Launch Pre-buy button
    * Validate message from Buyer
    * Send a message from Buyer to Seller
    * Logout Agency RFP

  Scenario: Seller receives the massage from Buyer (MBSB)
    * Login to Stratasphere
    * Search for RFP in Stratasphere
    * Validate "RFP Details" Page in Stratasphere
    * Validate the message from Buyer
    * Logout from Stratasphere