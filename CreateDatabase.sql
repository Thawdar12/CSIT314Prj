create table profile
(
    profileID          bigint auto_increment
        primary key,
    profileName        varchar(50)   not null,
    profileDescription varchar(2000) null,
    isEnabled          bit           not null,
    constraint profile_pk
        unique (profileName)
);

create table user
(
    userID        bigint auto_increment
        primary key,
    averageRating double       not null,
    created_at    datetime(3)  not null,
    email         varchar(100) not null,
    enabled       bit          not null,
    password      varchar(255) not null,
    phoneNumber   varchar(20)  not null,
    updated_at    datetime(3)  not null,
    userType      VARCHAR(50)  not null,
    username      varchar(50)  not null,
    constraint user_pk
        unique (username),
    constraint user_pk_2
        unique (phoneNumber),
    constraint user_pk_3
        unique (email),
    constraint user_profile_profileName_fk
        foreign key (userType) references profile (profileName)
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
    listedBy         varchar(50)             not null,
    sellerUsername   varchar(50)             not null,
    viewCount        int                     not null,
    constraint carlistings_pk
        unique (carPlateNumber),
    constraint carlistings_user_username_fk
        foreign key (listedBy) references user (username),
    constraint carlistings_user_username_fk_2
        foreign key (sellerUsername) references user (username)
);

create table review
(
    id        bigint auto_increment
        primary key,
    comment   varchar(1000)  null,
    createdAt datetime(3)    not null,
    rating    decimal(10, 2) not null,
    reviewFor varchar(50)    not null,
    reviewBy  varchar(50)    not null,
    constraint review_user_username_fk
        foreign key (reviewBy) references user (username),
    constraint review_user_username_fk_2
        foreign key (reviewFor) references user (username)
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


