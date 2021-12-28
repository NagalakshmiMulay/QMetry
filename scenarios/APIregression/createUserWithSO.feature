Scenario Outline: Create user with outline
    Given User sets the base URL
    And   User sets the Request Payload '${id}','${username}','${firstName}','${lastName}','${password}','${email}','${phone}','${userStatus}'
    Then  User validates the valid response payload for list of users '${id}' and status code is 200

Examples:
| id| username | firstName|lastName |password|email|phone|userStatus|
| 114 | nagalakshmi15 | nagalakshmi |mulay|nagalakshmi15|nagalakshmi15@gmail.com|8888888787|0|
| 119 | nagalakshmi19 | nagalakshmi |mulay|nagalakshmi19|nagalakshmi15@gmail.com|8888888719|0|
| 120 | nagalakshmi20 | nagalakshmi |mulay|nagalakshmi20|nagalakshmi15@gmail.com|8888888720|0|
