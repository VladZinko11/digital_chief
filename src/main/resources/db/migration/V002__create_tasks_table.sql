CREATE TABLE tasks
(
    id         BIGSERIAL PRIMARY KEY,
    type       VARCHAR(255),
    project_id BIGINT REFERENCES projects
);
