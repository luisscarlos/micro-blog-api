
API made to [micro blog frontend](https://github.com/luisscarlos/micro-blog-web) that allows to create posts like a news blog and add comments to each post.


## Tecnologies and tools

 - **[Spring Boot](https://spring.io/projects/spring-boot)**
 - **[Spring Data JPA](https://spring.io/projects/spring-data-jpa#overview)** 
- **[Hibernate](https://hibernate.org/orm/)**
- **[Lombok](https://projectlombok.org/)**
- **[Docker](https://www.docker.com/)**
- **[PostgreSQL](https://www.postgresql.org/)**
- **[Swagger](https://swagger.io/)**


### Features
- Create, edit and delete a post.
- List all posts.
- Search a post by title or tags
- Create, edit or delete a comment to a post.


## Run Locally

- Clone the project

```bash
  git clone https://github.com/luisscarlos/micro-blog-api.git
```
- Run docker with terminal in root folder to start database
```bash
  docker-compose up -d
```

- Import cloned project to your preferred IDE
- Run the file MicroblogApplication.java

API documentation can be found at http://localhost:8081/swagger-ui/index.html after application starts, and below.

## Routes
News Controller
| Method  | Path  | Description  |
| ------------ | ------------ | ------------ |
| GET  |  /api/news | List all news |
| GET  | /api/news/{id}  | List news by id  |
| GET  | /api/news/filter/title/{title}  | List news correspondents by title  |
| GET  | /api/news/filter/tags/{tags}  | List news correspondents by tags  |
| DELETE  | /api/news/{id}  | Delete news by id  |
| POST  | /api/news  | Create news  |
| PUT  | /api/news/{id}  | Update news  |

Comment Controller
| Method  | Path  | Description  |
| ------------ | ------------ | ------------ |
| GET  | /api/comment  | List all comments  |
| GET  | /api/comment/{id}  | Get comment by id  |
| DELETE  | /api/comment/{id}  | Delete comment by id  |
| POST  | /api/comment/{newsId}  | Create comment by newsId  |
| PUT  | /api/comment/{id}  | Update comment by id  |

-Insomnia collection file can be found in root folder with the name MicroblogInsomniaCollection.json.
## License

[MIT](https://choosealicense.com/licenses/mit/)

