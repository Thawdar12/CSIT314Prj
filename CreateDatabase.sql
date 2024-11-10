create table user
(
    userID        bigint auto_increment
        primary key,
    averageRating double                                     not null,
    created_at    datetime(3)                                not null,
    email         varchar(100)                               not null,
    enabled       bit                                        not null,
    password      varchar(255)                               not null,
    phoneNumber   varchar(20)                                not null,
    updated_at    datetime(3)                                not null,
    userType      enum ('ADMIN', 'AGENT', 'BUYER', 'SELLER') null,
    username      varchar(50)                                not null,
    constraint UKatqgqm46rh7b0lrgl80ryd5tp
        unique (username),
    constraint UKkbwn0on0lnegf5lckdxvlu495
        unique (phoneNumber),
    constraint UKmbarshl1giy6v93ewbfoqtim2
        unique (email)
);

create table carlistings
(
    listingID        bigint auto_increment
        primary key,
    carBrand         varchar(255)            not null,
    carModel         varchar(255)            not null,
    carPlateNumber   varchar(255)            not null,
    created_at       datetime(3)             not null,
    listingStatus    enum ('CLOSED', 'OPEN') not null,
    manufacturedYear varchar(255)            not null,
    millage          varchar(255)            not null,
    photo            text                    null,
    price            double                  not null,
    updated_at       datetime(3)             not null,
    listedBy         bigint                  not null,
    seller_id        bigint                  not null,
    favorite         bigint                  DEFAULT 0,
    constraint UK3oasb4n1acr4kl6j9h63poby5
        unique (carPlateNumber),
    constraint FK8mxrm0fxek63e4274m2pgbyv4
        foreign key (listedBy) references user (userID),
    constraint FKac7efr49wux1fh8w2ncyb8q1s
        foreign key (seller_id) references user (userID)
);

create table review
(
    id        bigint auto_increment
        primary key,
    comment   varchar(1000)  null,
    createdAt datetime(3)    not null,
    rating    decimal(10, 2) not null,
    reviewFor bigint         not null,
    reviewBy  bigint         not null,
    constraint FKjchjtsqwf4hco76ygvo5af4pa
        foreign key (reviewBy) references user (userID),
    constraint FKr63muddle4s28qw1jrfi72jby
        foreign key (reviewFor) references user (userID)
);

create table favourite
(
    favId        bigint auto_increment
        primary key,
    favFor          bigint          not null,
    favBy           bigint          not null,
    created_at      DATETIME(3)     not null DEFAULT CURRENT_TIMESTAMP,

    constraint FK_favFor_listingID
        foreign key (favFor) references carlistings (listingID),
    constraint FK_favBy_userID
        foreign key (favBy) references user (userID),
    UNIQUE (favFor, favBy)
);

INSERT INTO csit314database.user (averageRating, created_at, email, enabled, password, phoneNumber, updated_at,
                                  userType, username)
VALUES (0, '2024-10-27 20:35:07.000', 'admin@admin.com', true, 'admin', '12345678', '2024-10-27 20:35:22.000', 'ADMIN',
        'admin');


