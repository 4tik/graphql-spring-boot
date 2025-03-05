DROP TABLE if EXISTS books;
CREATE TABLE books(
    id SERIAL        PRIMARY KEY NOT NULL,
    title            VARCHAR(50),
    author           VARCHAR(100),
    price            FLOAT DEFAULT 0,
    isbn             VARCHAR(15) UNIQUE NOT NULL,
    publisher        VARCHAR(150),
    publication_date DATE,
    category         VARCHAR(150),
    language         VARCHAR(150),
    total_page       INT,
    stock_quantity   INT DEFAULT 0,
    created_at       TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at       TIMESTAMP
);

-- Insert a book with all fields
INSERT INTO books (title, author, price, isbn, publisher, publication_date, category, language, total_page, stock_quantity)
VALUES ('The Great Gatsby', 'F. Scott Fitzgerald', 12.99, '9780743273565', 'Scribner', '1925-04-10', 'Fiction', 'English', 180, 50);

-- Insert another book with all fields
INSERT INTO books (title, author, price, isbn, publisher, publication_date, category, language, total_page, stock_quantity)
VALUES ('1984', 'George Orwell', 9.99, '9780451524935', 'Signet Classics', '1949-06-08', 'Sci-Fi', 'English', 328, 30);

-- Insert a book with minimal fields (only required fields)
INSERT INTO books (title, author, isbn)
VALUES ('To Kill a Mockingbird', 'Harper Lee', '9780061120084');

-- Insert a book with some optional fields
INSERT INTO books (title, author, price, isbn, publisher, category, language, total_page, stock_quantity)
VALUES ('Pride and Prejudice', 'Jane Austen', 7.99, '9780141439518', 'Penguin Classics', 'Romance', 'English', 432, 25);

-- Insert a book with a future publication date
INSERT INTO books (title, author, price, isbn, publisher, publication_date, category, language, total_page, stock_quantity)
VALUES ('Future Book', 'John Doe', 19.99, '9781234567890', 'Future Publisher', '2025-01-01', 'Mystery', 'English', 300, 0);