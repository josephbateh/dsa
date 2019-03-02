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
  https://dsa-prod.herokuapp.com/sorting/bubble \
  -H 'Content-Type: application/json' \
  -d '{
	"list": [2, 3, 1]
}'
```