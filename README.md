
We have two microservices here implementing the CQRS pattern, separating read and write operations into distinct services. These services communicate asynchronously using the Redis pub-sub mechanism. 
The command service publishes an event when a product is saved, and the query service, which subscribes to the product-event topic, receives and processes this event, then persists it into its own database. 
Additionally, we've applied the @Retryable annotation to handle any failures that might occur during event processing.
Our main goal here was to implement the CQRS pattern, though a much more complex scenario could be envisioned, of course.


![Ekran görüntüsü 2024-05-02 223906](https://github.com/teomangungoren/cqrs/assets/105017822/4a02e911-0e9d-4825-b3f3-15a9e3ba4323)
![Ekran görüntüsü 2024-05-02 224307](https://github.com/teomangungoren/cqrs/assets/105017822/ad4c4427-2f98-4b98-b15d-20aa6e185aa4)
![Ekran görüntüsü 2024-05-02 224324](https://github.com/teomangungoren/cqrs/assets/105017822/71460148-5a9b-4187-b6a0-cdc69e10bfad)

