# api-development-spring-boot
Project for spring boot api development learning

## Important links
- Spring boot initializer - https://start.spring.io/
- Richardson Maturity Model
  - Level 0
  - Level 1 = Resource URI properly
  - Level 2 = Level1 + Http Methods
  - Level 3 = Level2 + Hateoas (Data + Next Possible Actions)  

## Topics Covered
### Spring Boot Rest App
- **Exception handling** and generic exception handling for all resources (important concept)
- **Validation** e.g. name should have atleast 2 characters OR dob should not be future dated
- Creating bean and using with @AutoWired
- HATEOAS - sending links for other data with the requested data
- Advanced Restful Services - Internationalization
- Advanced Restful Services - Content Negotiation
- API documentation using Swagger/OAS3.0 (Swagger UI link and API docs link)
- API monitoring with actuators and HAL browser (link)
- Filtering (filtering out the attributes and not the rows) - static (@JsonIgnore)
- Filtering - dynamic (through code)
- **Versioning** - Different URI OR Different Request Params OR Different Headers
  - URI versioning (twt)
  - Request parameter versioning (amz)
  - Header versioning (MS)
  - Media/Mime type versioning (Accept/Produces) (GT)
- Basic authentication security
- JPA (Java Persistence API)
  - It defines handling database as the entities/object. (like Realm and Room)
  - JPA is an interface and Hibernate is most popular implementation of JPA

- H2 - In memory database
  - In memory database gets cleared up on server restart

- Relationship between entities (Many to One and One to Many)


### Versioning FActors -- looks request param versioning is good for caching and api documentation -- No perfect solution
- URI pollution
- Http headers misuse
- Caching
- API documentation
- Need to check how API Gateway and Lambda works???

### Best Practices:
- Consumer First
- Documentation
- Make use of Http methods and response status
- No secure info in the URI
- Using plurals
- Use nouns for resources (For exceptions - have a consistent approach)

