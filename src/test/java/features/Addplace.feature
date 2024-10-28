Feature: Validate Place Api's
@Addplace @regression
  Scenario Outline: verify if place is being successfully added using
  
  Given Add place Api with "<Name>" "<Language>" "<Address>"
  When User calls "AddApi" with "POST" request
  Then The APi call is successsfull with status 200
  And "status" in the body is "OK"
  And "scope" in the body is "APP"
  And Verify placeid generated match with "<Name>" while calling "Getapi"
  
  Examples:
  |Name  |Language |Address          |
  |Vishnu|Malayalam|Kochin,Kerala    |
 # |Tenson|Tamil    |chennai,TamilNadu|
 
 @DeletePlace @regression
 Scenario: Verify user able to delete the created place
 Given Delete api payload
 When User calls "Deleteapi" with "POST" request
 Then The APi call is successsfull with status 200
 And "status" in the body is "OK"
