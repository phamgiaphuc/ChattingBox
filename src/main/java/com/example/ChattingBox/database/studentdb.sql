CREATE TABLE subject (
    id int PRIMARY KEY,
    subject_id varchar(255) UNIQUE NOT NULL,
    subject_name varchar(255) NOT NULL,
    created_date date NOT NULL,
    updated_date date NOT NULL
);

CREATE TABLE student_score (
    id int PRIMARY KEY,
    student_id varchar(255) UNIQUE NOT NULL,
    subject_id varchar(255) UNIQUE NOT NULL,
    test_time int UNIQUE NOT NULL,
    test_score int NOT NULL,
    created_date date NOT NULL,
    updated_date date NOT NULL
);

ALTER TABLE "student_score" ADD FOREIGN KEY ("subject_id") REFERENCES "subject" ("subject_id");

CREATE SEQUENCE subject_sequence
    AS integer
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1
    NO CYCLE
    OWNED BY subject.id;

CREATE SEQUENCE student_score_sequence
    AS integer
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1
    NO CYCLE
    OWNED BY student_score.id;