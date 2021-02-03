CREATE TABLE customer
(
    id         serial
        CONSTRAINT customer_pk
            PRIMARY KEY,
    created_at timestamp NOT NULL
);

CREATE TABLE customer_detail
(
    id          serial      NOT NULL
        CONSTRAINT customer_detail_pk
            PRIMARY KEY,
    customer_id integer     NOT NULL
        CONSTRAINT customer_detail_customer_id_fk
            REFERENCES customer
            ON DELETE CASCADE,
    name        varchar(10) NOT NULL,
    created_at  timestamp   NOT NULL
);


