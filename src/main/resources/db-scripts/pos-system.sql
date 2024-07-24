CREATE TABLE customer
(
    id      VARCHAR(15) PRIMARY KEY,
    name    VARCHAR(100) NOT NULL,
    address VARCHAR(500) NOT NULL
);
CREATE TABLE contact
(
    contact     VARCHAR(15) NOT NULL PRIMARY KEY ,
    customer_id VARCHAR(15) NOT NULL ,
    CONSTRAINT fk_contact FOREIGN KEY (customer_id) REFERENCES customer (id)
);
CREATE TABLE item
(
    code  VARCHAR(50) PRIMARY KEY,
    name  VARCHAR(100)  NOT NULL,
    stock INT           NOT NULL,
    price DECIMAL(9, 2) NOT NULL
);

CREATE TABLE `user`
(
    username VARCHAR(100) PRIMARY KEY,
    password VARCHAR(200) NOT NULL,
    name     VARCHAR(200) NOT NULL
);
CREATE TABLE `order`
(
    id            VARCHAR(10) PRIMARY KEY,
    date          DATE         NOT NULL,
    user_username VARCHAR(100) NOT NULL,
    customer_id   VARCHAR(15) NOT NULL ,
    CONSTRAINT fk_customer FOREIGN KEY (customer_id) REFERENCES customer (id),
    CONSTRAINT fk_user FOREIGN KEY (user_username) REFERENCES `user` (username)
);

CREATE TABLE orderItem
(
    order_id  VARCHAR(10)   NOT NULL,
    item_code VARCHAR(50)   NOT NULL,
    discount       INT           NOT NULL,
    price     DECIMAL(8, 2) NOT NULL,
    CONSTRAINT pk_order_item PRIMARY KEY (order_id, item_code),
    CONSTRAINT fk_order FOREIGN KEY (order_id) REFERENCES `order` (id),
    CONSTRAINT fk_item FOREIGN KEY (item_code) REFERENCES item (code)
);