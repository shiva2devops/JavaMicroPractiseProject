Create two controller:

hospital/save: check if name not available throw exception HostpitalNameNotFoundException
hospital/update check if hospital city not available: HostpitalCityNotFoundException

Write the integration test for these two controller with and without exception.


HostpitalNameNotFoundException: BAD_REQUEST=400

HostpitalCityNotFoundException: NOT_FOUND=404

## Build application

mvn clean install

## start application

mvn spring-boot:run