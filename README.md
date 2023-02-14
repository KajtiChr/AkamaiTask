# Akamai Task
Crude project for recruitment process - Maciej Kajetan Chrzanowski

## 1. Provided solution

Solution obtain:
- Connection to db,
- Entity of SocialNetworkPosts,
- Service where whole logic of each endpoint has been delivered.
- Controllers that invoke specify service method for each endpoint.
- Decided to make 2 endpoints (1 from task and additional one that gets all data)
- Test cases for Controller and Service

## 2. Needed improvements

So for sure my test are poorly written, so that's the obvious things to work with.
Wasn't sure if CrudRepository has to be used for this particular solution or I can use JPA Repository.
I'm not sure if getting more features without proper testing will be worth showing that's why I focused on getting knowledge with testing.


## 3. What would I add + plan/tools/classes I would use

So from my perspective there's several pieces that might be working in this project.
I do not know what's the purpose of this solution would be, but I would provide more Crud operations, Page inside JPARepository interface for manipulating size, page number and offset: ```Page<?> findBySpecifyParameter(@RequestParam(${specifyParam}) String specifyParam, Pageable pageable);``` . I would also add db column Users.
Users with enum user/admin. Add login feature with proper authorization for some endpoints.
```
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final SocialNetworkPostService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    }
```

Additionally add restriction to some CRUD operations for user:
```
@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {
    private String theAllowedOrigins = "http://localhost:3000"; //endpoint for front

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {

        HttpMethod[] theUnsupportedActions = {
                HttpMethod.DELETE,
                HttpMethod.POST,
                HttpMethod.PATCH,
                HttpMethod.PUT};

        config.exposeIdsFor(*.class);

        disableHttpMethods(*.class, config, theUnsupportedActions);

        cors.addMapping(config.getBasePath() + "/**").allowedOrigins(theAllowedOrigins);


    }

    private void disableHttpMethods(Class theClass, RepositoryRestConfiguration config, HttpMethod[] theUnsupportedAction){
        config.getExposureConfiguration()
                .forDomainType(theClass)
                .withItemExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedAction))
                .withCollectionExposure((meta, httpMethods) -> httpMethods.disable(theUnsupportedAction));
    }
}
```

## Closure

To sum up everything, I would give myself around 4.5-5 out of 10, test hasn't been done properly.
I'm not sure that I get point of the task. At the end of the project I realized that probably I should have used more features and show off more skills related with CRUD applications.
