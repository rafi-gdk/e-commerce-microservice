This application provides all Security Information

Pre Requisites : Java 19 and Gradle 7.6 and Postgres

Install Postgres:
> docker run --name postgresql -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=123456789 -p 5432:5432 -d postgres

Used topics:

1.Http all Requests

2.Form Validations

3.PathVariable Validations

4.Postgres db by setting up all required info in application.yml variables

5.Used Global Exception handler

6.docker images

7.kubernetes deployments

------------------------------------------------------------------------------------------------------------------------------------------
All Services Request URLS & Body

Post:
URL:- http://localhost:9001/security-jwt/authenticate
Body:-
{
"userName": "rafi",
"password": "1234"
}

Get:
URL:- http://localhost:9001/security-jwt/validate-token

Headers:
Content-Type:application/json
Authorization:Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJyYWZpIiwiaWF0IjoxNjg2NDgyOTI5LCJleHAiOjE2ODY0ODI5ODl9.fK8zs4Zl7AhPS3xEc5QgbyFz8313VCUGL81OYgvKRDc

------------------------------------------------------------------------------------------------------------------------------------------