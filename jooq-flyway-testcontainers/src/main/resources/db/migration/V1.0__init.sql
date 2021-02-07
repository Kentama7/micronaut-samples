CREATE TABLE customer
(
    id         serial
        CONSTRAINT customer_pk
            PRIMARY KEY,
    created_at timestamp NOT NULL
);
