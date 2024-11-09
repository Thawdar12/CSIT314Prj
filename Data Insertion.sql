-- Insert profiles into the 'profile' table
INSERT INTO profile (profileName, profileDescription, isEnabled)
VALUES ('ADMIN', 'Administrator profile', true),
       ('BUYER', 'Buyer profile', true),
       ('SELLER', 'Seller profile', true),
       ('AGENT', 'Agent profile', true);

-- Insert User
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, password, phoneNumber, updated_at,
                                  userType, username)
VALUES (0, '2024-11-09T03:42:35.369', 'admin@admin.com', true, 'admin', '12345678',
        '2024-11-09T03:42:35.369', 'ADMIN', 'admin');

INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-09T07:33:20.117', 'Marc4@example.org', true, '+65 13652787', '2024-11-10T02:37:17.411', 'BUYER',
        'Toni_Lesch84', 'LnqBJdhNE9Skb8Q');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-09T05:48:00.643', 'Jerrod49@example.org', false, '+65 17884175', '2024-11-10T02:37:50.681',
        'AGENT', 'Roy.Kerluke', 'rfh3C_qXgzQouOw');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-07T10:08:18.848', 'Durward1@example.org', true, '+65 19976388', '2024-11-10T02:40:21.663',
        'ADMIN',
        'Damion_Thompson', '4NyNzcbSjtqb3N1');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-09T23:39:29.157', 'Micheal_Paucek@example.com', false, '+65 44845056',
        '2024-11-10T02:44:51.778', 'BUYER', 'Mable68', 's7Ueu2RVl7wa5GH');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-07T20:37:34.230', 'Agnes_Bartoletti24@example.org', false, '+65 05680823',
        '2024-11-10T02:39:20.252', 'BUYER', 'Violet34', 'nAXqtCOZE7yVbd7');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-06T14:32:16.751', 'Myron_Feest85@example.org', true, '+65 54917471', '2024-11-10T02:39:13.628',
        'ADMIN', 'Jacey_Rowe', 'DhPS7lvyMO3H5ly');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-08T11:24:02.573', 'Gabriel9@example.net', true, '+65 18554937', '2024-11-10T02:37:18.825',
        'BUYER',
        'Hayden47', 'JU_Uh3wmhydodLE');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-06T07:51:15.616', 'Bethel.Fay@example.com', true, '+65 13806804', '2024-11-10T02:41:39.850',
        'BUYER', 'Piper.Reilly18', 's05YSArCWY3N46_');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-07T17:59:17.490', 'Emmett54@example.org', false, '+65 67819886', '2024-11-10T02:40:02.752',
        'SELLER', 'Ari_Mraz', '7n_KiQ2N6tbmnVv');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-09T06:09:23.403', 'Dominique.McCullough@example.org', false, '+65 22301988',
        '2024-11-10T02:44:34.248', 'ADMIN', 'Stacy.Trantow', '9aV8s1vDxLkV80b');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-08T00:27:40.300', 'Heath59@example.org', true, '+65 06442018', '2024-11-10T02:37:58.441',
        'ADMIN',
        'Isabella_Hartmann', '6AIG3zWfkVCreFA');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-08T01:25:58.878', 'Meredith.Walker@example.org', false, '+65 44123788',
        '2024-11-10T02:37:39.667', 'SELLER', 'Carter24', '22N44_7_EDInX0n');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-06T06:02:55.703', 'Lula.Hammes@example.com', false, '+65 19263072', '2024-11-10T02:40:59.636',
        'AGENT', 'Candelario_Larkin', 'UZy2kVxGBXvUfx7');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-09T15:06:51.933', 'Nichole_Stiedemann@example.net', false, '+65 27834441',
        '2024-11-10T02:41:49.980', 'ADMIN', 'Verona76', 'ECylluCjC_478dQ');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-06T16:46:20.470', 'Niko.Haag7@example.com', true, '+65 94339493', '2024-11-10T02:45:04.231',
        'ADMIN', 'Daphne.Kirlin56', 'd8IhmSxuHV0eJdw');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-07T04:58:50.714', 'Mckenna_Lowe@example.net', true, '+65 50313400', '2024-11-10T02:43:06.488',
        'AGENT', 'Elsie_Willms', 'r28krg_yiMJsDYz');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-08T22:13:38.636', 'Jakayla_Muller@example.org', false, '+65 67887363',
        '2024-11-10T02:38:51.854', 'BUYER', 'Leopold.Lockman', 'yZSqgVmAhK4tfhj');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-08T07:41:16.329', 'Enos.Rosenbaum@example.net', false, '+65 52020786',
        '2024-11-10T02:39:55.934', 'BUYER', 'Jakob_Heller75', 'lpf7s4F2Tk1qZKL');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-08T19:30:29.619', 'Jarret_Kassulke64@example.org', true, '+65 48975415',
        '2024-11-10T02:40:28.828', 'SELLER', 'Issac88', 'TqfghlWfNH9Ss0O');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-08T09:21:54.311', 'Anya_Koepp@example.com', false, '+65 78785539', '2024-11-10T02:44:54.857',
        'BUYER', 'Demetris85', 'Z0x7qHGyAeRVyhq');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-06T23:40:20.260', 'Bobby_Schmeler86@example.com', true, '+65 52477971',
        '2024-11-10T02:44:48.267', 'AGENT', 'Toy25', 'vvhvjz4nJQDj_LQ');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-08T03:01:57.499', 'Jacques_Satterfield53@example.com', false, '+65 42296923',
        '2024-11-10T02:43:57.854', 'ADMIN', 'Alanis.Lueilwitz96', '6fRoiGBV6u0eBvB');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-09T07:04:42.480', 'Rickey31@example.com', true, '+65 75665070', '2024-11-10T02:42:14.973',
        'BUYER',
        'Mandy.Baumbach25', 'OlK1yj7BP3YJGC7');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-08T20:24:15.254', 'Onie_Schoen@example.org', false, '+65 85497986', '2024-11-10T02:38:23.651',
        'SELLER', 'Americo.Collier', 'Zq7l9cWpBb3eVmO');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-08T02:49:50.992', 'Abner32@example.org', true, '+65 80777621', '2024-11-10T02:44:26.824',
        'ADMIN',
        'Scotty_Predovic', 'rWloERR4xnQ8GLk');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-09T17:54:02.234', 'Sonny91@example.org', true, '+65 06869277', '2024-11-10T02:42:25.719',
        'BUYER',
        'Bartholome.Stroman', '_DnMQgXIZk1nCjc');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-07T23:18:32.439', 'Evangeline76@example.com', false, '+65 67857966', '2024-11-10T02:44:47.542',
        'AGENT', 'Gideon.Collins', 'd6UI7B6rN5up_2W');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-09T21:33:54.092', 'Amir_Johnston@example.net', true, '+65 31897574', '2024-11-10T02:41:11.360',
        'BUYER', 'Shirley.Muller', '5TJ1YJQGWQSZLax');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-09T19:31:23.411', 'Mose_Okuneva54@example.com', false, '+65 19939706',
        '2024-11-10T02:37:41.244', 'ADMIN', 'Kiarra_Medhurst', 'W6wILd_DjFRK4sf');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-08T21:17:31.273', 'Bria.Graham@example.net', false, '+65 15197776', '2024-11-10T02:45:10.427',
        'SELLER', 'Addie5', 'Jzw985cN1VPexT1');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-09T11:01:40.786', 'Ashtyn51@example.net', false, '+65 47081679', '2024-11-10T02:41:09.502',
        'BUYER', 'Roel_White9', 'CHSKClE7TX3jhQp');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-09T17:35:13.613', 'Janae.Bergstrom@example.net', false, '+65 72751216',
        '2024-11-10T02:37:43.797', 'BUYER', 'Haylee.Mante21', '_vGnenf9dTxOAN6');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-07T21:07:40.573', 'Judson.Douglas7@example.com', false, '+65 58240488',
        '2024-11-10T02:44:53.863', 'ADMIN', 'Name84', 'clsYJz4BGaECbAF');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-09T10:03:19.024', 'Jordane.Jaskolski7@example.com', false, '+65 81565860',
        '2024-11-10T02:41:47.073', 'ADMIN', 'Holden.Okuneva', 't1EM6oJrMFCDpT2');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-08T10:42:21.971', 'Anthony.Wolff23@example.net', true, '+65 45783035',
        '2024-11-10T02:43:47.798', 'AGENT', 'Colten4', 'bgInePqNLoFQ_BC');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-10T00:15:45.586', 'Flavie57@example.com', true, '+65 85678813', '2024-11-10T02:43:21.573',
        'ADMIN',
        'George_Herman66', 'q0CU1ZRWJxW0EX6');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-08T16:11:50.297', 'Levi_Marks@example.com', false, '+65 21628291', '2024-11-10T02:43:50.568',
        'BUYER', 'Bettie15', 'Nuw5ZXn2HlJgVWC');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-07T03:51:18.415', 'Scarlett92@example.org', true, '+65 24652848', '2024-11-10T02:39:40.935',
        'SELLER', 'Christ_Reinger25', 'o9JLemKSh6n2k3H');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-08T00:09:27.527', 'Erwin.White@example.net', false, '+65 32480368', '2024-11-10T02:39:01.030',
        'ADMIN', 'Deontae_Green52', 'LSmFUqunMpzD03A');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-08T09:52:47.119', 'Ottis.Collier@example.org', true, '+65 72650322', '2024-11-10T02:43:32.955',
        'ADMIN', 'Jesus_Dibbert39', 'ID_QyzclAQ5tm7U');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-07T19:33:59.173', 'Eladio87@example.net', true, '+65 11405501', '2024-11-10T02:40:04.890',
        'SELLER',
        'Clare_Davis34', 'kvRmTqnbw2YTJHV');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-05T23:01:18.848', 'Johnson6@example.com', false, '+65 27493452', '2024-11-10T02:41:52.510',
        'ADMIN', 'Duane_Sipes60', 'g9w0ahOD_8LX6fw');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-08T19:23:08.860', 'Asa.Osinski13@example.org', true, '+65 83136992', '2024-11-10T02:40:20.170',
        'ADMIN', 'Darrel_Rosenbaum', 'xLCorIuP9hVo7M0');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-10T02:15:23.519', 'Vickie.Schaden34@example.org', false, '+65 02357412',
        '2024-11-10T02:37:20.702', 'AGENT', 'Sarai_Dicki', '_czyPPyGOJXE_HV');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-06T17:06:48.720', 'Shania_Schumm@example.com', false, '+65 72842854', '2024-11-10T02:44:55.775',
        'ADMIN', 'Nova6', 'oRgkGyGojqaq3Mq');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-07T10:40:53.359', 'Jaida_Abshire@example.com', true, '+65 76889426', '2024-11-10T02:39:32.017',
        'SELLER', 'Percy_Effertz67', 'CXtDyByOyMK4wfs');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-07T13:42:18.279', 'Katlynn_Blanda21@example.com', false, '+65 98944044',
        '2024-11-10T02:45:12.663', 'ADMIN', 'Allison44', 'RJp7LweNr2L0viQ');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-08T13:59:17.610', 'Jaycee_Witting2@example.org', true, '+65 48043010',
        '2024-11-10T02:40:54.322', 'SELLER', 'Travon_Mayert96', 'w_AAhXZ0fvY3yQI');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-07T12:53:56.547', 'Marcellus_Barrows@example.net', false, '+65 71073487',
        '2024-11-10T02:39:40.484', 'ADMIN', 'Sam91', 'peVjSATvNdR5I5f');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-08T22:53:45.918', 'Dino93@example.org', true, '+65 22963773', '2024-11-10T02:37:50.914',
        'SELLER',
        'Sofia72', 'WWbERwtOpOJ4KgW');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-08T19:17:23.938', 'Destin4@example.com', true, '+65 96063088', '2024-11-10T02:44:30.481',
        'ADMIN',
        'Eliza.Maggio', 'VOzE0yhotlsjYSA');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-07T09:49:30.725', 'Maud_Kessler@example.org', false, '+65 08273182', '2024-11-10T02:41:07.221',
        'ADMIN', 'Raina79', 'ar3gjdEUdJtnVV7');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-07T01:52:41.708', 'Abner.Waters34@example.org', true, '+65 89817150', '2024-11-10T02:41:40.386',
        'SELLER', 'Chaz.Schuster', 'rqFrdxz7ewC_Spw');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-07T13:57:35.071', 'Casey_Watsica@example.net', true, '+65 84124294', '2024-11-10T02:44:06.921',
        'ADMIN', 'Charity.Smith76', 'm_wnOPjkA2J8FVa');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-06T11:34:25.700', 'Caleigh36@example.org', false, '+65 94792941', '2024-11-10T02:44:18.955',
        'SELLER', 'Olen_Turcotte', '3JnrsSodkUtQeb0');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-08T04:19:11.662', 'Nola.Swaniawski@example.org', false, '+65 15904891',
        '2024-11-10T02:39:39.123', 'SELLER', 'Rowland.Harris23', 'c0bOwQPoNo7kJgZ');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-09T13:38:07.596', 'Elizabeth85@example.org', true, '+65 01992996', '2024-11-10T02:37:51.690',
        'SELLER', 'Winnifred.Murray', 'iOOExXmvZzmykpQ');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-09T21:50:31.195', 'Madisen.OReilly91@example.com', true, '+65 77845022',
        '2024-11-10T02:43:44.317', 'AGENT', 'Dale_Graham', 'c6Da7RYPMcOqC1z');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-06T11:45:50.038', 'Milford_Wisozk@example.com', false, '+65 75292333',
        '2024-11-10T02:37:08.773', 'AGENT', 'Oceane18', 'hPbqAd12xjr2kw3');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-08T07:25:56.853', 'Mazie66@example.net', true, '+65 77154348', '2024-11-10T02:38:33.922',
        'SELLER',
        'Ole.Rolfson', 'U1H0JuY28CTBsJG');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-07T09:28:23.779', 'Victoria.Brakus@example.net', true, '+65 58784337',
        '2024-11-10T02:42:00.016', 'SELLER', 'Roscoe70', '7q804ksB6MUyiCI');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-09T17:05:23.336', 'Jayde.Veum@example.com', false, '+65 30242136', '2024-11-10T02:40:40.916',
        'ADMIN', 'Rahsaan_Satterfield', '512FKmubMZvIgMl');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-09T00:49:33.156', 'Gerson_Murray@example.org', true, '+65 29640483', '2024-11-10T02:42:02.170',
        'AGENT', 'Annamae_DAmore95', 'nxo1bPCQbCbYDqu');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-06T06:45:24.730', 'Rudolph8@example.org', true, '+65 22003720', '2024-11-10T02:37:46.438',
        'SELLER',
        'Grace_VonRueden', '9kO2Sk6QReMzStc');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-09T02:04:00.755', 'Marguerite_Rowe22@example.com', false, '+65 29269461',
        '2024-11-10T02:41:53.549', 'BUYER', 'Aurelie_OConner', 'DVVyH9FhdjnjB9X');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-09T16:59:52.361', 'Alize.Hamill45@example.net', false, '+65 01055759',
        '2024-11-10T02:43:05.468', 'SELLER', 'Keyshawn_Prosacco95', '6AEgvbd5GMulSYC');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-08T08:33:50.634', 'Sunny_Kohler@example.net', true, '+65 39595973', '2024-11-10T02:39:30.973',
        'SELLER', 'Mayra.Sanford', 'fex18lvKS9WSG7y');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-09T10:08:53.869', 'Pink.Berge41@example.net', true, '+65 78813713', '2024-11-10T02:38:06.800',
        'ADMIN', 'Donnie_Macejkovic39', 'FOcCZjnywEJTgRl');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-08T05:32:28.925', 'Keely_Murray29@example.com', false, '+65 09699518',
        '2024-11-10T02:39:33.545', 'ADMIN', 'Afton80', '8M1kGSCE6wQf2EL');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-08T06:15:45.286', 'Augusta27@example.org', true, '+65 39603524', '2024-11-10T02:40:32.863',
        'AGENT', 'Petra_Schinner', '05YrbiZkNx0YbID');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-06T13:24:12.309', 'Tamara.Jast41@example.net', true, '+65 55637847', '2024-11-10T02:43:59.045',
        'SELLER', 'Coty42', 'gztBtJy17_Hh7do');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-06T18:32:25.882', 'Rae63@example.net', false, '+65 21782431', '2024-11-10T02:45:16.990',
        'SELLER',
        'Emery.Hane22', 'TO_FfS6h9aeCbjX');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-06T16:14:52.885', 'Rolando_Kreiger@example.org', true, '+65 05742642',
        '2024-11-10T02:43:41.081', 'ADMIN', 'Abbie.Graham', 'Xaq0Qcj_MBCuVbz');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-10T02:02:29.577', 'Isom_Simonis26@example.org', false, '+65 85198847',
        '2024-11-10T02:40:11.245', 'BUYER', 'Willard_Bogan', 'Ah1BHn3m6SjDrla');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-07T02:10:55.541', 'Russel19@example.org', true, '+65 42855000', '2024-11-10T02:45:06.861',
        'SELLER',
        'Maude.Boyer', 'QhRCTHV1gBpm17I');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-07T10:45:02.452', 'Blanca_Blick@example.net', true, '+65 21505528', '2024-11-10T02:37:19.638',
        'ADMIN', 'Jaunita.Weber', 'MxvPcm3ho51h4w7');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-09T19:45:29.339', 'Lauretta.Schowalter68@example.org', true, '+65 55039967',
        '2024-11-10T02:45:16.700', 'SELLER', 'Meagan_Hudson', '5LM1CchpVPjgtiO');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-07T13:22:29.171', 'Bill77@example.com', true, '+65 53543214', '2024-11-10T02:41:14.825',
        'SELLER',
        'Shannon94', 'b_tXPTVWnb7NYX6');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-08T18:41:37.020', 'Arlo.Schulist39@example.com', false, '+65 53023437',
        '2024-11-10T02:39:12.573', 'ADMIN', 'Kelley.Schowalter', '_AwItURryXYI5Wr');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-09T11:21:52.214', 'Colton11@example.com', false, '+65 55767259', '2024-11-10T02:43:10.795',
        'BUYER', 'Angel.Stroman', 'N_MeWNqztEy4jC3');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-06T14:08:27.584', 'Reyna.Brown@example.com', true, '+65 97118910', '2024-11-10T02:43:54.151',
        'ADMIN', 'Sadye_Gutkowski9', 'y7dFZHj7W38iYbc');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-06T23:53:43.221', 'Vincent37@example.org', true, '+65 90678077', '2024-11-10T02:43:11.112',
        'BUYER', 'Cordie_Smith', 'hwOPjz8cFTS3p3i');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-05T22:43:21.262', 'Leanne99@example.com', true, '+65 75034759', '2024-11-10T02:41:37.518',
        'AGENT',
        'Lenora15', 'bDwszzUwQwWXPq1');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-06T16:53:09.173', 'Odessa.Graham@example.org', true, '+65 87825336', '2024-11-10T02:42:19.316',
        'BUYER', 'Trinity_Harvey71', 'P8blyEnW49fHTRH');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-07T06:19:34.109', 'Alanis.Osinski@example.com', false, '+65 23338833',
        '2024-11-10T02:43:09.666', 'ADMIN', 'Florine_Rolfson7', '28JICKsxXiYsjG0');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-07T03:23:21.731', 'Adrian.Leuschke@example.org', false, '+65 25847834',
        '2024-11-10T02:42:44.089', 'ADMIN', 'Jennie_Nader', 'aptakLG_esR_UnF');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-06T18:57:46.028', 'Billy_Klein59@example.net', true, '+65 41058481', '2024-11-10T02:44:17.504',
        'BUYER', 'Buford_Effertz', 'ATQHcZkGvrgEODp');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-06T11:35:46.588', 'Savannah_Becker@example.net', false, '+65 84764695',
        '2024-11-10T02:38:26.545', 'ADMIN', 'Milton89', 'kMtIvtc32KaouKb');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-08T11:04:24.377', 'Hazle_Lebsack@example.net', true, '+65 87365683', '2024-11-10T02:38:37.395',
        'AGENT', 'Skylar_Mayert71', 'TyhcPRsRvL7cuD7');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-10T00:32:20.050', 'Garth.Veum60@example.org', false, '+65 95220289', '2024-11-10T02:43:48.029',
        'BUYER', 'Trace.Stracke59', 'GleeDP6AIHc57yo');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-08T22:08:08.589', 'Isadore.McKenzie58@example.net', false, '+65 90293584',
        '2024-11-10T02:42:50.761', 'AGENT', 'Alysa_Breitenberg', 'FtZ_JDY_XMKRAlY');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-06T12:55:11.156', 'Joey.Dickinson@example.com', true, '+65 97694894', '2024-11-10T02:41:58.538',
        'AGENT', 'Justice.Mills', 'G0VkgRjdLYekHr3');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-06T13:40:56.051', 'Lindsey9@example.net', false, '+65 56241957', '2024-11-10T02:40:36.776',
        'SELLER', 'Bradford30', '57nmxArZ_yVSCPf');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-08T07:58:25.112', 'Alexandra.Haley@example.com', false, '+65 89562216',
        '2024-11-10T02:39:43.941', 'ADMIN', 'Aurore53', '9PZeDE_x9hqvzZj');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-06T15:45:32.262', 'Vernice_Price24@example.org', true, '+65 82802911',
        '2024-11-10T02:37:22.034', 'SELLER', 'Keyshawn_Goldner16', 'BoWUWLi57dHmm1Y');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-09T13:05:10.437', 'Hattie.Gibson22@example.net', false, '+65 88570398',
        '2024-11-10T02:42:57.583', 'BUYER', 'Brant.Bernier70', 'Ihqf37XMPY3VBG4');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-07T22:09:10.247', 'Rex_Altenwerth@example.com', false, '+65 38945064',
        '2024-11-10T02:44:30.904', 'ADMIN', 'Milton_Fadel', 'jGyq0mLupXOlSe4');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-07T13:06:14.224', 'Ralph.Luettgen@example.org', false, '+65 27368274',
        '2024-11-10T02:45:20.920', 'ADMIN', 'Declan2', 'yBAfEMIRnGCEIP_');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-09T04:51:04.326', 'Winston97@example.com', false, '+65 12129110', '2024-11-10T02:39:10.144',
        'ADMIN', 'Frederique70', '70yrRyZTtyycEa6');
INSERT INTO csit314database.user (averageRating, created_at, email, enabled, phoneNumber, updated_at, userType,
                                  username, password)
VALUES ('0', '2024-11-09T13:49:47.203', 'Norbert.Wintheiser17@example.org', false, '+65 07685171',
        '2024-11-10T02:41:39.322', 'BUYER', 'Raoul54', 'SiBhWi3JXR7AvRR');

-- Insert Listing
-- 1
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Polestar', 'PT Cruiser', 'RM12MVX', '2024-11-08T01:49:09.550', 'OPEN', '2006', '2356.11', '/img/car(6).jpg',
        '700012.00', '2024-11-10T20:54:06.671', 'Roy.Kerluke', 'Ari_Mraz', '3348');

-- 2
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Lamborghini', 'Altima', 'FY13WSK', '2024-11-04T02:23:27.459',
        'CLOSED', '1990', '9130.55', '/img/car(5).jpg', '572416.00', '2024-11-10T07:30:13.381', 'Candelario_Larkin',
        'Carter24', '6378');

-- 3
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Dodge', 'CTS', 'QQ30CYY', '2024-11-05T09:52:16.553', 'OPEN',
        '1990', '1964.91', '/img/car(19).jpg', '418181.00', '2024-11-10T21:06:33.651', 'Elsie_Willms', 'Issac88',
        '6186');

-- 4
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Tesla', 'Alpine', 'OK20VUP', '2024-10-30T18:47:07.095',
        'CLOSED', '2004', '13618.41', '/img/car(9).jpg', '153451.00', '2024-11-10T11:55:13.936', 'Toy25',
        'Americo.Collier', '6780');

-- 5
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Mercedes Benz', 'Wrangler', 'RQ62GCD', '2024-11-03T01:35:23.516',
        'CLOSED', '2010', '14700.44', '/img/car(8).jpg', '22364.00', '2024-11-10T08:42:23.574', 'Gideon.Collins',
        'Addie5', '3143');

-- 6
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Cadillac', 'LeBaron', 'FJ57XOW', '2024-11-02T15:42:48.118',
        'OPEN', '1999', '14345.66', '/img/car(12).jpg', '616737.00', '2024-11-12T09:01:58.314', 'Colten4',
        'Christ_Reinger25', '2251');

-- 7
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Chrysler', 'Camaro', 'CS75GUA', '2024-10-29T10:36:39.600',
        'OPEN', '2016', '20920.54', '/img/car(11).jpg', '772832.00', '2024-11-11T20:42:25.870', 'Sarai_Dicki',
        'Clare_Davis34', '3669');

-- 8
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Ford', 'Jetta', 'JJ87MQV', '2024-10-28T21:17:56.753',
        'OPEN', '2016', '12427.85', '/img/car(4).jpg', '646085.00', '2024-11-11T19:24:34.723', 'Dale_Graham',
        'Percy_Effertz67', '7507');

-- 9
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Fiat', 'V90', 'YL84DGD', '2024-11-01T21:39:45.487',
        'CLOSED', '2011', '19262.33', '/img/car(13).jpg', '383548.00', '2024-11-12T03:18:29.413', 'Oceane18',
        'Travon_Mayert96', '6283');

-- 10
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Fiat', 'Aventador', 'GO41OHE', '2024-11-07T21:09:57.413',
        'CLOSED', '1997', '11472.24', '/img/car(10).jpg', '391679.00', '2024-11-11T11:58:09.303', 'Annamae_DAmore95',
        'Sofia72', '464');

-- 11
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Bugatti', 'Model Y', 'IL22DGG', '2024-10-30T07:47:16.505',
        'OPEN', '2013', '20480.17', '/img/car(5).jpg', '763655.00', '2024-11-11T14:46:12.785', 'Petra_Schinner',
        'Chaz.Schuster', '458');

-- 12
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Nissan', 'Accord', 'RG47UAL', '2024-11-06T00:34:59.334',
        'CLOSED', '1999', '11894.93', '/img/car(9).jpg', '785169.00', '2024-11-11T16:40:18.915', 'Lenora15',
        'Olen_Turcotte', '7344');

-- 13
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Aston Martin', 'CX-9', 'LR05ZYZ', '2024-11-04T05:13:36.319',
        'CLOSED', '2016', '5810.22', '/img/car(15).jpg', '731415.00', '2024-11-11T14:01:05.868', 'Skylar_Mayert71',
        'Rowland.Harris23', '4828');

-- 14
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Polestar', 'Model 3', 'UY30SPG', '2024-11-04T10:38:29.918',
        'OPEN', '1992', '26657.16', '/img/car(13).jpg', '674180.00', '2024-11-10T19:46:24.938', 'Alysa_Breitenberg',
        'Winnifred.Murray', '6986');

-- 15
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Jeep', 'Civic', 'IY70WHR', '2024-10-30T01:00:29.380',
        'OPEN', '2014', '115', '/img/car(15).jpg', '618692.00', '2024-11-10T07:26:49.525', 'Justice.Mills',
        'Ole.Rolfson', '9968');

-- 16
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('BMW', 'Ranchero', 'QQ62JWA', '2024-11-03T14:33:29.304',
        'CLOSED', '2020', '27126.68', '/img/car(2).jpg', '700763.00', '2024-11-10T17:03:01.418', 'Roy.Kerluke',
        'Roscoe70', '8276');

-- 17
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Bugatti', 'Aventador', 'BH34PEG', '2024-11-08T01:55:16.717',
        'CLOSED', '2002', '22159.01', '/img/car(6).jpg', '435568.00', '2024-11-12T03:23:41.454', 'Candelario_Larkin',
        'Grace_VonRueden', '6256');

-- 18
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Mazda', 'Aventador', 'HZ90AMY', '2024-11-07T07:26:09.949',
        'OPEN', '2011', '21461.84', '/img/car(8).jpg', '377565.00', '2024-11-11T22:28:13.867', 'Elsie_Willms',
        'Keyshawn_Prosacco95', '3007');

-- 19
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Land Rover', '1', 'UC45RPT', '2024-11-05T04:42:19.155',
        'OPEN', '2015', '23296.48', '/img/car(4).jpg', '658794.00', '2024-11-10T10:45:58.790', 'Toy25',
        'Mayra.Sanford', '4131');

-- 20
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Lamborghini', 'Wrangler', 'VB57PEA', '2024-11-06T05:39:11.008',
        'CLOSED', '1990', '719.42', '/img/car(19).jpg', '245275.00', '2024-11-10T07:19:43.484', 'Gideon.Collins',
        'Coty42', '2935');

-- 21
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Bentley', 'Impala', 'PE80ONT', '2024-10-28T09:01:04.358',
        'OPEN', '2020', '11123.54', '/img/car(17).jpg', '151459.00', '2024-11-10T05:18:11.565', 'Colten4',
        'Emery.Hane22', '1859');

-- 22
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Nissan', 'A4', 'IG13OTH', '2024-11-09T01:45:26.560',
        'CLOSED', '2002', '5098.44', '/img/car(14).jpg', '196487.00', '2024-11-11T22:17:52.956', 'Sarai_Dicki',
        'Maude.Boyer', '2233');

-- 23
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Bentley', '2', 'IX94VLJ', '2024-11-07T14:46:17.860',
        'OPEN', '1995', '23685.28', '/img/car(15).jpg', '113404.00', '2024-11-12T05:48:11.036', 'Dale_Graham',
        'Meagan_Hudson', '762');

-- 24
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('BMW', 'Focus', 'WR96SFV', '2024-10-28T02:56:03.247',
        'CLOSED', '2017', '29473.18', '/img/car(2).jpg', '460490.00', '2024-11-10T18:49:37.638', 'Oceane18',
        'Shannon94', '866');

-- 25
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Toyota', 'Altima', 'TM86GIR', '2024-11-09T07:43:15.337',
        'OPEN', '2009', '14137.28', '/img/car(2).jpg', '941157.00', '2024-11-11T17:06:57.296', 'Annamae_DAmore95',
        'Bradford30', '8775');

-- 26
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Cadillac', 'LeBaron', 'MZ86FTM', '2024-11-08T23:09:05.521',
        'OPEN', '1994', '14032.09', '/img/car(18).jpg', '647606.00', '2024-11-11T17:44:14.516', 'Petra_Schinner',
        'Keyshawn_Goldner16', '1046');

-- 27
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Tesla', 'XTS', 'AZ75SCO', '2024-11-08T00:39:34.535',
        'CLOSED', '1994', '11322.03', '/img/car(9).jpg', '892627.00', '2024-11-12T02:43:38.595', 'Lenora15',
        'Ari_Mraz', '7784');

-- 28
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Hyundai', 'Ranchero', 'LR04HSH', '2024-11-05T12:25:14.424',
        'OPEN', '2007', '7140.92', '/img/car(6).jpg', '505909.00', '2024-11-10T22:07:11.785', 'Skylar_Mayert71',
        'Carter24', '8959');

-- 29
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Hyundai', 'Explorer', 'VJ25UUT', '2024-11-09T21:54:04.135',
        'OPEN', '1998', '12424.38', '/img/car(15).jpg', '600563.00', '2024-11-11T12:28:24.622', 'Alysa_Breitenberg',
        'Issac88', '4926');

-- 30
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Chevrolet', 'Accord', 'HI60CNG', '2024-10-31T08:49:19.104',
        'CLOSED', '1993', '4932.34', '/img/car(10).jpg', '379112.00', '2024-11-11T11:12:51.383', 'Justice.Mills',
        'Americo.Collier', '9899');

-- 31
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Jeep', 'Beetle', 'KH53VRX', '2024-11-03T16:03:36.164',
        'CLOSED', '2000', '15693.87', '/img/car(20).jpg', '471674.00', '2024-11-10T09:31:48.167', 'Roy.Kerluke',
        'Addie5', '7835');

-- 32
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Mercedes Benz', 'El Camino', 'OL10VYH', '2024-10-27T18:52:27.885',
        'OPEN', '2010', '7661.01', '/img/car(8).jpg', '624026.00', '2024-11-10T10:57:01.161', 'Candelario_Larkin',
        'Christ_Reinger25', '168');

-- 33
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Kia', 'XC90', 'JA75GMC', '2024-11-04T17:54:54.454',
        'OPEN', '2000', '8867.29', '/img/car(2).jpg', '86123.00', '2024-11-12T07:56:04.898', 'Elsie_Willms',
        'Clare_Davis34', '9155');

-- 34
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Porsche', 'Fortwo', 'DB66WIX', '2024-11-04T13:49:46.004',
        'CLOSED', '1997', '29532.32', '/img/car(19).jpg', '163640.00', '2024-11-10T17:13:12.617', 'Toy25',
        'Percy_Effertz67', '4899');

-- 35
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Toyota', 'Jetta', 'CG67RKM', '2024-11-03T15:45:27.947',
        'OPEN', '2009', '556.72', '/img/car(3).jpg', '916841.00', '2024-11-11T07:24:19.172', 'Gideon.Collins',
        'Travon_Mayert96', '2063');

-- 36
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Jeep', 'Fortwo', 'UQ24DSQ', '2024-11-03T10:47:16.873',
        'CLOSED', '1992', '26369.7', '/img/car(4).jpg', '465976.00', '2024-11-10T19:57:29.330', 'Colten4',
        'Sofia72', '5626');

-- 37
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Bentley', 'LeBaron', 'GJ72ZAK', '2024-11-07T01:58:39.597',
        'CLOSED', '2014', '12444.47', '/img/car(15).jpg', '46646.00', '2024-11-11T19:24:55.222', 'Sarai_Dicki',
        'Chaz.Schuster', '7667');

-- 38
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Polestar', 'Corvette', 'YN14MGQ', '2024-11-04T10:02:44.071',
        'CLOSED', '2020', '2194.59', '/img/car(20).jpg', '869622.00', '2024-11-12T00:05:07.678', 'Dale_Graham',
        'Olen_Turcotte', '8028');

-- 39
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Lamborghini', '1', 'HT92PIN', '2024-11-01T18:57:03.054',
        'CLOSED', '2015', '1341.7', '/img/car(14).jpg', '162446.00', '2024-11-11T22:11:07.010', 'Oceane18',
        'Rowland.Harris23', '6294');

-- 40
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Mazda', 'Taurus', 'OF54EED', '2024-11-09T18:24:34.478',
        'OPEN', '2019', '6236.99', '/img/car(9).jpg', '202703.00', '2024-11-11T22:17:05.012', 'Annamae_DAmore95',
        'Winnifred.Murray', '6480');

-- 41
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Ford', 'Fortwo', 'CQ55ISO', '2024-11-05T00:03:13.390',
        'CLOSED', '2013', '29672.38', '/img/car(2).jpg', '207674.00', '2024-11-10T05:42:43.551', 'Petra_Schinner',
        'Ole.Rolfson', '5056');

-- 42
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Audi', 'Accord', 'LW27QZJ', '2024-10-29T02:37:24.575',
        'OPEN', '2013', '541.97', '/img/car(15).jpg', '650330.00', '2024-11-10T20:59:03.939', 'Lenora15',
        'Roscoe70', '2212');

-- 43
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Lamborghini', 'Mercielago', 'XH47PCO', '2024-11-06T05:15:37.391',
        'CLOSED', '2019', '24081.47', '/img/car(4).jpg', '709949.00', '2024-11-11T05:46:16.871', 'Skylar_Mayert71',
        'Grace_VonRueden', '4393');

-- 44
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Ferrari', 'Countach', 'FD25WME', '2024-11-02T08:26:16.196',
        'OPEN', '2013', '17310.86', '/img/car(2).jpg', '618644.00', '2024-11-11T03:12:29.966', 'Alysa_Breitenberg',
        'Keyshawn_Prosacco95', '7101');

-- 45
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('BMW', 'Challenger', 'ZM90EWF', '2024-11-05T02:06:17.143',
        'CLOSED', '2013', '29792.71', '/img/car(18).jpg', '931936.00', '2024-11-10T11:36:51.929', 'Justice.Mills',
        'Mayra.Sanford', '1708');

-- 46
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Nissan', 'A8', 'DI27VVV', '2024-11-06T09:17:08.504',
        'CLOSED', '2011', '15116.71', '/img/car(7).jpg', '992603.00', '2024-11-10T02:44:30.301', 'Roy.Kerluke',
        'Coty42', '3000');

-- 47
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Porsche', '911', 'SU91KDN', '2024-11-01T02:48:37.364',
        'OPEN', '2015', '25803.64', '/img/car(11).jpg', '465634.00', '2024-11-12T09:31:31.651', 'Candelario_Larkin',
        'Emery.Hane22', '2447');

-- 48
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Toyota', 'V90', 'GW28YAP', '2024-11-07T21:02:29.361',
        'OPEN', '1993', '2619.99', '/img/car(4).jpg', '926483.00', '2024-11-10T10:34:36.644', 'Elsie_Willms',
        'Maude.Boyer', '9344');

-- 49
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Land Rover', 'Fiesta', 'CY10SWL', '2024-10-30T22:52:26.989',
        'OPEN', '2003', '21587.13', '/img/car(11).jpg', '471899.00', '2024-11-11T03:41:40.901', 'Toy25',
        'Meagan_Hudson', '3586');

-- 50
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Bugatti', 'Accord', 'CI29FDX', '2024-10-30T11:00:00.491',
        'CLOSED', '2006', '18147.88', '/img/car(10).jpg', '709413.00', '2024-11-12T08:59:41.318', 'Gideon.Collins',
        'Shannon94', '5767');

-- 51
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Aston Martin', 'Sentra', 'WB92EVS', '2024-11-09T03:57:14.285',
        'CLOSED', '2008', '26678.44', '/img/car(12).jpg', '688096.00', '2024-11-10T18:22:06.591', 'Colten4',
        'Bradford30', '1812');

-- 52
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Chevrolet', 'Model S', 'LM21HVV', '2024-10-30T13:50:09.837',
        'OPEN', '2002', '16730.19', '/img/car(15).jpg', '973394.00', '2024-11-11T15:31:09.715', 'Sarai_Dicki',
        'Keyshawn_Goldner16', '1316');

-- 53
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Cadillac', 'Alpine', 'KD59SLE', '2024-10-29T08:42:21.180',
        'CLOSED', '2015', '14805.52', '/img/car(6).jpg', '651966.00', '2024-11-10T21:53:04.099', 'Dale_Graham',
        'Ari_Mraz', '2272');

-- 54
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('BMW', 'Golf', 'SX92WWX', '2024-10-28T01:07:49.949',
        'OPEN', '2018', '17178.58', '/img/car(17).jpg', '807126.00', '2024-11-10T21:58:16.135', 'Oceane18',
        'Carter24', '754');

-- 55
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Lamborghini', 'Element', 'SL50YPF', '2024-10-29T10:46:26.995',
        'OPEN', '2000', '24472.19', '/img/car(15).jpg', '127093.00', '2024-11-12T03:58:04.391', 'Annamae_DAmore95',
        'Issac88', '2908');

-- 56
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Aston Martin', 'Grand Caravan', 'NH59PQO', '2024-10-30T17:53:32.980',
        'CLOSED', '2001', '1260.55', '/img/car(9).jpg', '517649.00', '2024-11-10T12:14:10.468', 'Petra_Schinner',
        'Americo.Collier', '9156');

-- 57
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Polestar', 'Accord', 'TA58ZXE', '2024-11-03T23:52:28.323',
        'OPEN', '2017', '12890.33', '/img/car(17).jpg', '879910.00', '2024-11-10T06:10:30.356', 'Lenora15',
        'Addie5', '6948');

-- 58
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Ford', 'ATS', 'HR75DXX', '2024-11-09T18:27:41.668',
        'CLOSED', '2002', '14159.08', '/img/car(15).jpg', '446855.00', '2024-11-12T03:46:57.051', 'Skylar_Mayert71',
        'Christ_Reinger25', '8461');

-- 59
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Mazda', 'Focus', 'DU87ROR', '2024-11-02T22:21:44.118',
        'OPEN', '2016', '5900.2', '/img/car(19).jpg', '994820.00', '2024-11-10T07:36:18.572', 'Alysa_Breitenberg',
        'Clare_Davis34', '5577');

-- 60
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Polestar', 'Grand Cherokee', 'RI95MMT', '2024-11-08T07:12:19.159',
        'CLOSED', '2002', '3718.79', '/img/car(10).jpg', '434213.00', '2024-11-12T01:08:50.369', 'Justice.Mills',
        'Percy_Effertz67', '9756');

-- 61
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Hyundai', 'XTS', 'II33XTO', '2024-10-29T14:53:57.701',
        'OPEN', '2001', '21465.5', '/img/car(15).jpg', '990282.00', '2024-11-10T05:39:35.032', 'Roy.Kerluke',
        'Travon_Mayert96', '5874');

-- 62
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Jaguar', 'Mercielago', 'OW26XIL', '2024-11-06T18:31:22.088',
        'CLOSED', '2001', '552.38', '/img/car(4).jpg', '318516.00', '2024-11-10T21:25:55.501', 'Candelario_Larkin',
        'Sofia72', '8410');

-- 63
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Nissan', 'Golf', 'SU32IYK', '2024-10-31T16:41:40.222',
        'OPEN', '1993', '25986.18', '/img/car(2).jpg', '928185.00', '2024-11-10T20:41:56.334', 'Elsie_Willms',
        'Chaz.Schuster', '5907');

-- 64
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('BMW', 'ATS', 'DG59WUJ', '2024-11-07T16:09:01.296',
        'CLOSED', '2012', '13264.53', '/img/car(6).jpg', '139302.00', '2024-11-11T05:59:42.973', 'Toy25',
        'Olen_Turcotte', '5646');

-- 65
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Bentley', 'Focus', 'VG89DCE', '2024-11-09T17:40:06.238',
        'CLOSED', '1996', '9356.33', '/img/car(9).jpg', '533238.00', '2024-11-11T09:20:06.580', 'Gideon.Collins',
        'Rowland.Harris23', '658');

-- 66
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Ferrari', 'Model Y', 'BU21UFE', '2024-10-28T12:53:25.221',
        'OPEN', '2019', '2684.53', '/img/car(4).jpg', '513416.00', '2024-11-12T09:03:38.516', 'Colten4',
        'Winnifred.Murray', '5296');

-- 67
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Toyota', 'Explorer', 'IZ39VAQ', '2024-11-05T15:55:44.432',
        'CLOSED', '2013', '6556.48', '/img/car(3).jpg', '419871.00', '2024-11-10T06:36:21.607', 'Sarai_Dicki',
        'Ole.Rolfson', '4253');

-- 68
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Nissan', 'Grand Cherokee', 'BH95DUO', '2024-10-28T07:53:15.812',
        'OPEN', '2004', '26777.84', '/img/car(11).jpg', '193919.00', '2024-11-10T07:31:48.970', 'Dale_Graham',
        'Roscoe70', '2374');

-- 69
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Toyota', 'Model S', 'NV33TMQ', '2024-10-29T09:43:25.193',
        'OPEN', '2000', '28852.15', '/img/car(7).jpg', '974042.00', '2024-11-10T19:17:31.552', 'Oceane18',
        'Grace_VonRueden', '6928');

-- 70
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Cadillac', 'ATS', 'QM06VUR', '2024-11-07T16:34:51.734',
        'CLOSED', '2007', '23354.78', '/img/car(5).jpg', '99256.00', '2024-11-12T05:48:11.808', 'Annamae_DAmore95',
        'Keyshawn_Prosacco95', '7227');

-- 71
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Volvo', 'Grand Cherokee', 'CL02JUG', '2024-11-05T22:03:48.486',
        'CLOSED', '1990', '14873.39', '/img/car(18).jpg', '495250.00', '2024-11-10T04:08:39.627', 'Petra_Schinner',
        'Mayra.Sanford', '1619');

-- 72
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Mercedes Benz', 'Volt', 'TM18WNL', '2024-10-29T03:03:17.766',
        'CLOSED', '2020', '25958.3', '/img/car(1).jpg', '309239.00', '2024-11-10T22:34:57.098', 'Lenora15',
        'Coty42', '8585');

-- 73
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Cadillac', '2', 'QR56TIP', '2024-11-09T23:11:30.512',
        'OPEN', '2002', '212.88', '/img/car(8).jpg', '343891.00', '2024-11-10T12:57:54.120', 'Skylar_Mayert71',
        'Emery.Hane22', '1275');

-- 74
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Volkswagen', 'Wrangler', 'MK06YJT', '2024-11-02T00:20:41.994',
        'CLOSED', '2004', '278.72', '/img/car(4).jpg', '652077.00', '2024-11-11T05:52:46.713', 'Alysa_Breitenberg',
        'Maude.Boyer', '5786');

-- 75
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Toyota', '2', 'UW93UOV', '2024-11-05T18:38:35.283',
        'OPEN', '2007', '20196.32', '/img/car(13).jpg', '270143.00', '2024-11-11T22:46:00.975', 'Justice.Mills',
        'Meagan_Hudson', '8311');

-- 76
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Fiat', 'Altima', 'SF50PVX', '2024-11-10T00:39:54.845',
        'OPEN', '2007', '21649.72', '/img/car(3).jpg', '685766.00', '2024-11-12T02:57:14.171', 'Roy.Kerluke',
        'Shannon94', '8961');

-- 77
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Kia', 'Model 3', 'IB10XQB', '2024-11-04T18:02:07.520',
        'CLOSED', '1992', '7998.25', '/img/car(1).jpg', '997073.00', '2024-11-11T23:17:41.633', 'Candelario_Larkin',
        'Bradford30', '7147');

-- 78
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Tesla', 'Camaro', 'ER51UQM', '2024-11-04T04:36:31.730',
        'OPEN', '1992', '20896.79', '/img/car(14).jpg', '75901.00', '2024-11-12T01:39:44.092', 'Elsie_Willms',
        'Keyshawn_Goldner16', '5116');

-- 79
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Honda', 'Grand Caravan', 'HA43BRU', '2024-11-07T00:36:48.533',
        'CLOSED', '2014', '15985.41', '/img/car(12).jpg', '119917.00', '2024-11-11T20:00:12.099', 'Toy25',
        'Ari_Mraz', '193');

-- 80
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Chrysler', 'ATS', 'UU87AYU', '2024-11-03T20:14:18.636',
        'OPEN', '1993', '2300.32', '/img/car(14).jpg', '221316.00', '2024-11-11T19:17:06.511', 'Gideon.Collins',
        'Carter24', '1807');

-- 81
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Aston Martin', 'Grand Cherokee', 'TH88LSG', '2024-11-08T02:13:10.872',
        'OPEN', '2016', '1310.48', '/img/car(6).jpg', '297852.00', '2024-11-11T18:43:29.553', 'Colten4',
        'Issac88', '2930');

-- 82
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Mini', 'F-150', 'LM51HQP', '2024-11-08T04:04:27.712',
        'CLOSED', '2006', '26612.75', '/img/car(18).jpg', '443429.00', '2024-11-11T23:17:02.562', 'Sarai_Dicki',
        'Americo.Collier', '5786');

-- 83
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Rolls Royce', 'Model S', 'IW82FTZ', '2024-11-05T15:09:47.759',
        'OPEN', '1994', '10323.21', '/img/car(5).jpg', '447650.00', '2024-11-10T13:16:55.212', 'Dale_Graham',
        'Addie5', '6541');

-- 84
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Bugatti', 'Countach', 'EL01TJQ', '2024-11-05T14:57:38.297',
        'CLOSED', '2017', '26306.53', '/img/car(13).jpg', '357887.00', '2024-11-12T08:58:16.287', 'Oceane18',
        'Christ_Reinger25', '5107');

-- 85
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Mini', 'A4', 'UI71HVY', '2024-10-29T04:05:05.635',
        'CLOSED', '2010', '8371.62', '/img/car(7).jpg', '963457.00', '2024-11-11T20:33:49.687', 'Annamae_DAmore95',
        'Clare_Davis34', '554');

-- 86
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('BMW', 'Volt', 'IX56GYS', '2024-11-05T08:30:48.748',
        'CLOSED', '1997', '25323.04', '/img/car(2).jpg', '326496.00', '2024-11-10T05:27:29.726', 'Petra_Schinner',
        'Percy_Effertz67', '2922');

-- 87
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Mazda', 'LeBaron', 'EW25FGL', '2024-11-08T09:49:04.139',
        'CLOSED', '2000', '22522.05', '/img/car(9).jpg', '738969.00', '2024-11-10T17:12:58.255', 'Lenora15',
        'Travon_Mayert96', '2225');

-- 88
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Rolls Royce', 'Sentra', 'XN69AJY', '2024-10-29T04:21:03.382',
        'CLOSED', '1994', '924.13', '/img/car(11).jpg', '274649.00', '2024-11-11T11:38:49.486', 'Skylar_Mayert71',
        'Sofia72', '213');

-- 89
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Jaguar', 'Malibu', 'DH76GBB', '2024-10-29T18:17:48.192',
        'CLOSED', '2011', '6132.62', '/img/car(9).jpg', '170546.00', '2024-11-12T08:34:42.955', 'Alysa_Breitenberg',
        'Chaz.Schuster', '4094');

-- 90
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Dodge', 'F-150', 'MG35IXH', '2024-11-04T03:26:49.362',
        'OPEN', '1997', '28148.09', '/img/car(3).jpg', '87326.00', '2024-11-11T12:44:33.602', 'Justice.Mills',
        'Olen_Turcotte', '3596');

-- 91
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Tesla', 'Grand Caravan', 'NO63SIZ', '2024-11-05T16:28:57.644',
        'OPEN', '2007', '28576.47', '/img/car(15).jpg', '151339.00', '2024-11-11T16:58:57.573', 'Roy.Kerluke',
        'Rowland.Harris23', '9031');

-- 92
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Audi', 'Element', 'FJ52PPT', '2024-11-08T07:10:43.610',
        'OPEN', '2012', '17232.65', '/img/car(9).jpg', '728003.00', '2024-11-11T20:51:40.367', 'Candelario_Larkin',
        'Winnifred.Murray', '5900');

-- 93
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Mazda', 'Alpine', 'BZ99SVE', '2024-10-28T13:51:48.002',
        'OPEN', '2003', '20068.51', '/img/car(20).jpg', '294620.00', '2024-11-11T01:06:36.274', 'Elsie_Willms',
        'Ole.Rolfson', '2196');

-- 94
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Jeep', 'Grand Caravan', 'PU11YOY', '2024-10-31T23:23:20.569',
        'CLOSED', '1996', '26507.48', '/img/car(5).jpg', '59860.00', '2024-11-10T10:42:02.713', 'Toy25',
        'Roscoe70', '9776');

-- 95
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Mini', 'XTS', 'MK47IRJ', '2024-11-03T08:34:20.947',
        'OPEN', '2013', '15224.47', '/img/car(7).jpg', '153384.00', '2024-11-10T17:05:39.544', 'Gideon.Collins',
        'Grace_VonRueden', '3351');

-- 96
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Smart', 'Beetle', 'IF71SNJ', '2024-11-08T16:06:18.825',
        'OPEN', '2002', '26462.64', '/img/car(5).jpg', '333104.00', '2024-11-10T18:26:09.385', 'Colten4',
        'Keyshawn_Prosacco95', '5754');

-- 97
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Bugatti', 'Camaro', 'SI60XXA', '2024-10-30T14:13:41.414',
        'OPEN', '2014', '1867.86', '/img/car(11).jpg', '301445.00', '2024-11-11T22:48:30.278', 'Sarai_Dicki',
        'Mayra.Sanford', '106');

-- 98
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Rolls Royce', 'A8', 'DP83NBO', '2024-10-30T01:21:23.910',
        'CLOSED', '1991', '3335.36', '/img/car(2).jpg', '639854.00', '2024-11-11T00:56:01.189', 'Dale_Graham',
        'Coty42', '6067');

-- 99
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Kia', 'Mustang', 'YR27YYQ', '2024-11-05T15:35:52.827',
        'CLOSED', '2005', '19691.83', '/img/car(15).jpg', '441601.00', '2024-11-11T13:53:36.976', 'Oceane18',
        'Emery.Hane22', '6355');

-- 100
INSERT INTO csit314database.carlistings (carBrand, carModel, carPlateNumber, created_at, listingStatus,
                                         manufacturedYear, millage, photo, price, updated_at, listedBy, sellerUsername,
                                         viewCount)
VALUES ('Mazda', 'Golf', 'BQ23SZN', '2024-10-27T17:34:00.176',
        'OPEN', '2004', '10444.09', '/img/car(19).jpg', '34408.00', '2024-11-10T02:58:50.874', 'Annamae_DAmore95',
        'Maude.Boyer', '5156');
