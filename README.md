[![Build Status](https://travis-ci.org/josephbateh/dsa.svg?branch=master)](https://travis-ci.org/josephbateh/dsa)

# Data Structures & Algorithms

Practice app for keeping up with data structures and algorithms.

## Deployments

The app hosts APIs for common sorting algorithms. The latest version is hosted on Heroku.
- Staging: https://dsa-stage.herokuapp.com/
- Production https://dsa-prod.herokuapp.com/

## Postman Collection

A Postman collection with defined API calls can be found [here](https://www.getpostman.com/collections/472ee940fdc8ec52f325).

## Curl Example

cURL
```
curl -X POST \
  https://dsa-prod.herokuapp.com/sort/bubble \
  -H 'Content-Type: application/json' \
  -d '{
	"list": [2, 3, 1]
}'
```

## Potential New Features

- Abstract the type of the List to allow for algorithms to be applied to any object that allows for comparison
- Create docker image
- Record sort durations to database and create dashboard
- Record history of transactions and allow them to be queried