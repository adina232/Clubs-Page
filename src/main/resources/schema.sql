create table clubs
    (
    id integer not null,
    content varchar(255),
    created_on timestamp(6),
    photo_url varchar(1000),
    title varchar(255),
    updated_on timestamp(6),
    primary key (id)
    );

create sequence clubs_seq start with 1 increment by 50;

INSERT INTO Clubs (id, title, photo_url, content, created_on, updated_on)
VALUES (
    (VALUES NEXT VALUE FOR clubs_seq),
    'Books',
    'https://images.pexels.com/photos/1387022/pexels-photo-1387022.jpeg?cs=srgb&dl=book-aesthetic-books-old-books-1387022.jpg&fm=jpg',
    'This is a book club.',
    CURRENT_TIMESTAMP(),
    CURRENT_TIMESTAMP()
), (
       (VALUES NEXT VALUE FOR clubs_seq),
       'Running Club',
       'https://ichef.bbci.co.uk/images/ic/1200x675/p09858fk.jpg',
       'This is a running club.',
       CURRENT_TIMESTAMP(),
       CURRENT_TIMESTAMP()
);

create table event
    (
    id integer not null,
    name varchar(255),
    created_on timestamp(6),
    photo_url varchar(255),
    type varchar(255),
    updated_on timestamp(6),
    start_time timestamp(6),
    end_time timestamp(6),
    club_id integer,
    primary key (id)
    );

create sequence events_seq start with 1 increment by 50;

INSERT INTO Event (id, name, start_time, end_time, type, photo_url, created_on, updated_on, club_id)
VALUES (
    (VALUES NEXT VALUE FOR clubs_seq),
    'Book club',
    CURRENT_TIMESTAMP(),
    CURRENT_TIMESTAMP(),
    'meeting',
    'https://media.istockphoto.com/id/1700069126/vector/diverse-hands-holding-books-book-club-lettering-education-concept.jpg?s=612x612&w=0&k=20&c=HtDrxkfKpy3kacPDlrJXZf7M-LOc7m_H9aULvjnStGw=',
    CURRENT_TIMESTAMP(),
    CURRENT_TIMESTAMP(),
    1
);
