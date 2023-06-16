CREATE TABLE user_account (
    id bigint PRIMARY KEY,
    name varchar(255) NOT NULL,
    email varchar(255) UNIQUE NOT NULL,
    password varchar(255) NOT NULL,
    created_date date NOT NULL
);

CREATE SEQUENCE user_account_sequence
    AS integer
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1
    NO CYCLE
    OWNED BY user_account.id;