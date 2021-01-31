Feature: webservice api call

  Scenario: sending get request
    Given url 'https://www.anapioficeandfire.com/api/books'
    When method GET
    Then status 200
	   And print response
	   And match response[0].authors == ["George R. R. Martin"]