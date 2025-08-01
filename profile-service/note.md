## NEO4J

NEO4J is a graph database management system that stores and manages data as interconnected nodes and relationships

- Node represents entities in your data. Each node can have properties, which are key-value pairs that store the actual attributes
- Relationships connect nodes and represent how entities relate to each other
- Label act as tags that group nodes into categories. A single node can have multiple labels - for instance, a person could be labeled as both "Employee" and "Manager," allowing you to query for all managers or all employees as needed.

**Neo4j** uses Cypher Query Language, a declarative query language designed specifically for graph databases.

**A hop** = traversing one relationship (edge) between two nodes.

### Cypher Query Language

- Cypher uses parenthesis ==()== for note, ==-->[]-->== for relationships, for example: "Find John, then follow his friend relationships to other people." --> (john:Person)-[:FRIEND]->(friend:Person)

---

#### Basic Syntax

**Node**

- Nodes are represented with parentheses, and you can optionally include a variable name, labels, and property filters.
  - The simplest node is just **()**, representing any node
  - Adding a variable gives you **(n)**, meaning "any node, and I'll refer to it as 'n'."
  - Labels refine this further: **(p:Person)** means "any node with the Person label, which I'll call 'p'.
  - Finally, you can _filter by properties_: **(p:Person {name: 'Alice'})** finds Person nodes where the name property equals 'Alice'.

**Relationships**

- follow a similar pattern but use square brackets and directional arrows.
  - The basic relationship is **-[]->**, indicating a directed relationship from left to right.
  - You can specify relationship types like **-[:KNOWS]->** or add variables and properties just like with nodes: **-[r:KNOWS {since: 2020}]->**.
  - The ==direction matters== in Neo4j - (a)-[:KNOWS]->(b) means "a knows b," while (a)<-[:KNOWS]-(b) means "b knows a."

---

#### Pattern Matching: The Heart of Cypher

Using ==MATCH== clause

- A simple pattern might find all people MATCH(p:Person)
- Adding relationship MATCH(p:Person) -[:Friend]-> (f:Person)
- Multiple hops MATCH(p:Person) -[:Friend]->() -[:Friend]-> (fof:Person)
- ==Variable-length paths== add another dimension of power. MATCH(p:Person) - [:Friend*1..3]-> (others)

#### Essential Clauses and Their Purposes

==CREATE== adds new nodes and relationships to your graph.

- CREATE (p:Person {name: 'Bob'}) creates a new person node
- CREATE (p:Person {name: 'Bob'}) -[:WORKS_FOR]-> (c:Company {name: 'Acme'})

==WHERE== adds filtering conditions that go beyond simple property matching.

- WHERE p.age > 25 AND p.name =~ '.\*son$' finds people over 25 whose names end in 'son'

==RETURN== specifies what data to retrieve from your matches.

- You can return entire nodes RETURN p, specific properties RETURN p.name, or computed values RETURN p.name, p.age \* 365 as days_lived
- The RETURN clause supports aggregation functions like COUNT(), SUM(), and COLLECT(), allowing you to summarize your graph data effectively.

==SET and REMOVE== handle property updates.

- SET can add new properties or update existing ones: SET p.last_login = timestamp()
- REMOVE deletes properties or labels: REMOVE p.temporary_flag

#### Advanced Pattern Techniques

==Optional matching== becomes crucial when you want to find patterns that might not exist for every starting point. OPTIONAL MATCH works like a LEFT JOIN in SQL

- MATCH (p:Person) OPTIONAL MATCH (p) -[:HAS_PHONE]-> (phone) finds all people and their phone numbers if they have them, but still returns people without phones
- MATCH (p:Person) -[:Friend]->(f), (p) -[:COLLEAGUE]-> (f) finds people who are both friends and colleagues with the same person. The comma creates an implicit AND condition between patterns.

## Spring Data Neo4j

Spring Data Neo4j provides an ==object-graph mapping (OGM)== layer that allows you to work with Neo4j using familiar Java objects and Spring conventions.

- Node entities represent the vertices in your graph, annotated with **_@Node_** ⛺
- Relationship entities, marked with **_@RelationshipProperties_**, model the edges between nodes when you need to store properties on relationships themselves.
- The **_@Relationship_** annotation defines how nodes connect to each other, specifying direction and relationship types.
- Repository: The framework provides **_Neo4jRepository<T, ID>_** as a base interface, which includes common operations like findById, save, delete, and findAll
- Auditing, Testing & Migrations
    - Enable auditing (createdBy, modifiedDate) via **@EnableNeo4jAuditing** on a config class
    - For testing, use **Testcontainers Neo4j plus** optional **Neo4j‑Migrations** to initialize clean data in tests or CI

**Note**: when use neo4j with Docker and run command 
```
docker run --publish=7474:7474 --publish=7687:7687 -e 'NEO4J_AUTH=neo4j/secret' neo4j:5
```
the port 7474 is used for http user interface and has default username and password is neo4j & neo4j despite being set 'NEO4J_AUTH=neo4j/secret'