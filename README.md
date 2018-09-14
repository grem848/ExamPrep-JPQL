# ORM + JPQL
Explain the rationale behind the topic Object Relational Mapping and the Pros and Cons in using ORM:

Pros
* Facilitates implementing domain model pattern.
* Huge reduction in code.
* Takes care of vendor specific code by itself.
* Cache Management — Entities are cached in memory thereby reducing load on the DB.
* Huge reduction in product-to-client time

Cons
* Increased startup time due to metadata preparation( not good for desktop applications).
* Huge learning curve without ORM.
* Relatively hard to fine tune and debug generated SQL. Not suitable for applications without a clean domain object model.


Discuss how we usually have queried a relational database:

Discuss the methods we can use to query a JPA design and compare with what you explained above:
