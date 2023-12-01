------ -> Chambre -----
insert into chambre (type, numero, prix_nuit, creation_date, last_modification_date, disponible) values ('LIT_DOUBLE', '392', 378.68, '2022-11-22', '2023-06-18', false);
insert into chambre (type, numero, prix_nuit, creation_date, last_modification_date, disponible) values ('CHAMBRE_PARENTAL', '258', 212.14, '2023-05-27', '2023-02-07', true);
insert into chambre (type, numero, prix_nuit, creation_date, last_modification_date, disponible) values ('LIT_DOUBLE', '110', 253.25, '2022-05-15', '2023-09-12', true);
insert into chambre (type, numero, prix_nuit, creation_date, last_modification_date, disponible) values ('LIT_DOUBLE', '208', 162.02, '2022-12-17', '2022-12-22', false);
insert into chambre (type, numero, prix_nuit, creation_date, last_modification_date, disponible) values ('LIT_SIMPLE', '356', 199.17, '2022-12-07', '2023-03-24', true);
insert into chambre (type, numero, prix_nuit, creation_date, last_modification_date, disponible) values ('LIT_KING_SIZE', '386', 465.51, '2022-07-09', '2023-09-13', true);
insert into chambre (type, numero, prix_nuit, creation_date, last_modification_date, disponible) values ('CHAMBRE_PARENTAL', '199', 415.82, '2022-11-21', '2022-06-28', true);
insert into chambre (type, numero, prix_nuit, creation_date, last_modification_date, disponible) values ('LIT_SIMPLE', '350', 357.6, '2022-08-01', '2022-02-28', true);
insert into chambre (type, numero, prix_nuit, creation_date, last_modification_date, disponible) values ('LIT_KING_SIZE', '310', 315.4, '2023-11-14', '2023-07-05', false);
insert into chambre (type, numero, prix_nuit, creation_date, last_modification_date, disponible) values ('LIT_DOUBLE', '257', 467.03, '2023-04-11', '2023-03-16', false);

------ -> Client -----
insert into client (creation_date, last_modification_date, nom, prenom, email, telephone) values ('2022-06-30', '2022-08-24', 'McCromley', 'Laughton', 'lmccromley0@163.com', '7253700747');
insert into client (creation_date, last_modification_date, nom, prenom, email, telephone) values ('2023-10-19', '2022-06-14', 'Caukill', 'Bear', 'bcaukill1@taobao.com', '3193630506');
insert into client (creation_date, last_modification_date, nom, prenom, email, telephone) values ('2022-03-23', '2023-03-07', 'Oldroyd', 'Cathee', 'coldroyd2@storify.com', '2954482108');
insert into client (creation_date, last_modification_date, nom, prenom, email, telephone) values ('2022-09-19', '2023-05-06', 'Leal', 'Elwood', 'eleal3@nyu.edu', '2059211680');
insert into client (creation_date, last_modification_date, nom, prenom, email, telephone) values ('2022-09-06', '2022-05-25', 'Webburn', 'Maisie', 'mwebburn4@surveymonkey.com', '9183358131');
insert into client (creation_date, last_modification_date, nom, prenom, email, telephone) values ('2023-11-13', '2022-12-04', 'Cottey', 'Nina', 'ncottey5@vinaora.com', '1015670758');
insert into client (creation_date, last_modification_date, nom, prenom, email, telephone) values ('2022-01-10', '2022-11-11', 'Melton', 'Ban', 'bmelton6@mail.ru', '5929841563');
insert into client (creation_date, last_modification_date, nom, prenom, email, telephone) values ('2022-11-29', '2022-10-10', 'Cersey', 'Oliver', 'ocersey7@lulu.com', '3647264090');
insert into client (creation_date, last_modification_date, nom, prenom, email, telephone) values ('2023-10-22', '2022-03-31', 'Roycroft', 'Siegfried', 'sroycroft8@census.gov', '2359032476');
insert into client (creation_date, last_modification_date, nom, prenom, email, telephone) values ('2023-01-20', '2022-10-18', 'Haggas', 'Bing', 'bhaggas9@ehow.com', '6506528230');

------ -> Service -----
insert into service (nom, description, creation_date, last_modification_date, tarif) values ('apero', 'integer pede justo lacinia eget tincidunt eget', '2022-07-19', '2022-03-21', 74.05);
insert into service (nom, description, creation_date, last_modification_date, tarif) values ('wifi', 'lectus suspendisse potenti in eleifend quam a odio in hac habitasse platea', '2022-02-09', '2023-10-13', 28.76);
insert into service (nom, description, creation_date, last_modification_date, tarif) values ('apero', 'ut erat curabitur gravida nisi at nibh in', '2022-07-21', '2023-11-28', 57.74);
insert into service (nom, description, creation_date, last_modification_date, tarif) values ('repas', 'sem praesent id massa id nisl venenatis lacinia aenean sit amet justo morbi ut odio', '2022-04-28', '2023-08-14', 68.69);
insert into service (nom, description, creation_date, last_modification_date, tarif) values ('apero', 'lacus at velit vivamus vel nulla', '2022-05-07', '2022-03-18', 50.16);
insert into service (nom, description, creation_date, last_modification_date, tarif) values ('repas', 'curabitur gravida nisi at nibh in hac habitasse platea dictumst aliquam augue quam sollicitudin vitae consectetuer eget', '2023-02-10', '2023-08-15', 32.52);
insert into service (nom, description, creation_date, last_modification_date, tarif) values ('spa', 'in lacus curabitur at ipsum ac tellus semper interdum mauris ullamcorper purus sit amet nulla quisque', '2023-09-08', '2022-04-19', 91.15);
insert into service (nom, description, creation_date, last_modification_date, tarif) values ('spa', 'tempus sit amet sem fusce consequat nulla nisl nunc nisl duis bibendum felis sed interdum venenatis turpis enim', '2023-09-23', '2023-11-09', 23.84);
insert into service (nom, description, creation_date, last_modification_date, tarif) values ('apero', 'curae donec pharetra magna vestibulum aliquet ultrices erat tortor sollicitudin mi sit', '2023-03-10', '2023-05-31', 33.89);
insert into service (nom, description, creation_date, last_modification_date, tarif) values ('wifi', 'non lectus aliquam sit amet diam', '2022-02-28', '2022-04-23', 61.25);

------ -> Reservation -----
insert into reservation (date_debut, date_fin, creation_date, last_modification_date, client_id, chambre_id) values ('2023-07-07', '2023-10-20', '2023-06-30', '2023-05-27', 2, 2);
insert into reservation (date_debut, date_fin, creation_date, last_modification_date, client_id, chambre_id) values ('2023-06-19', '2023-07-15', '2023-10-16', '2023-12-06', 5, 1);
insert into reservation (date_debut, date_fin, creation_date, last_modification_date, client_id, chambre_id) values ('2023-04-28', '2023-02-22', '2023-05-19', '2023-07-02', 5, 3);
insert into reservation (date_debut, date_fin, creation_date, last_modification_date, client_id, chambre_id) values ('2023-09-16', '2023-07-11', '2023-05-05', '2023-03-30', 10, 1);
insert into reservation (date_debut, date_fin, creation_date, last_modification_date, client_id, chambre_id) values ('2023-10-10', '2023-05-12', '2022-12-03', '2023-08-16', 6, 6);
insert into reservation (date_debut, date_fin, creation_date, last_modification_date, client_id, chambre_id) values ('2023-09-28', '2023-03-04', '2023-11-04', '2023-08-21', 9, 4);
insert into reservation (date_debut, date_fin, creation_date, last_modification_date, client_id, chambre_id) values ('2023-08-30', '2023-01-11', '2023-10-26', '2022-12-04', 3, 6);
insert into reservation (date_debut, date_fin, creation_date, last_modification_date, client_id, chambre_id) values ('2023-11-24', '2023-03-23', '2023-01-13', '2023-01-18', 9, 5);
insert into reservation (date_debut, date_fin, creation_date, last_modification_date, client_id, chambre_id) values ('2022-12-28', '2023-10-26', '2023-04-16', '2023-07-15', 9, 9);
insert into reservation (date_debut, date_fin, creation_date, last_modification_date, client_id, chambre_id) values ('2023-03-03', '2023-11-19', '2023-08-11', '2023-06-03', 10, 2);

------ -> Chambre_Service -----
insert into chambre_service (commentaire, heure, date, service_service_id, chambre_chambre_id) values ('ipsum praesent blandit lacinia erat vestibulum sed magna at nunc commodo placerat praesent', '6:20:37', '2023-11-09', 5, 7);
insert into chambre_service (commentaire, heure, date, service_service_id, chambre_chambre_id) values ('sit amet consectetuer adipiscing elit proin interdum mauris non ligula pellentesque ultrices phasellus id sapien in', '0:38:42', '2023-11-13', 5, 1);
insert into chambre_service (commentaire, heure, date, service_service_id, chambre_chambre_id) values ('non mattis pulvinar nulla pede ullamcorper augue a suscipit nulla elit ac nulla sed vel enim sit', '1:46:49', '2023-06-20', 10, 4);
insert into chambre_service (commentaire, heure, date, service_service_id, chambre_chambre_id) values ('adipiscing molestie hendrerit at vulputate vitae nisl aenean lectus pellentesque eget nunc donec', '9:19:06', '2023-09-12', 5, 8);
insert into chambre_service (commentaire, heure, date, service_service_id, chambre_chambre_id) values ('nunc viverra dapibus nulla suscipit ligula in lacus curabitur at ipsum ac tellus semper interdum mauris ullamcorper purus', '0:35:19', '2023-08-31', 8, 3);
insert into chambre_service (commentaire, heure, date, service_service_id, chambre_chambre_id) values ('duis faucibus accumsan odio curabitur convallis duis consequat dui nec nisi volutpat eleifend', '22:51:42', '2023-08-02', 6, 3);
insert into chambre_service (commentaire, heure, date, service_service_id, chambre_chambre_id) values ('aliquam convallis nunc proin at turpis a pede posuere nonummy integer non velit donec diam neque vestibulum eget vulputate', '2:02:58', '2023-01-26', 6, 4);
insert into chambre_service (commentaire, heure, date, service_service_id, chambre_chambre_id) values ('erat fermentum justo nec condimentum neque sapien placerat ante nulla justo aliquam quis turpis', '19:26:55', '2023-05-18', 1, 1);
insert into chambre_service (commentaire, heure, date, service_service_id, chambre_chambre_id) values ('ut erat id mauris vulputate elementum nullam varius nulla facilisi cras non velit nec nisi vulputate nonummy maecenas tincidunt lacus', '20:13:23', '2023-10-12', 3, 6);
insert into chambre_service (commentaire, heure, date, service_service_id, chambre_chambre_id) values ('ipsum aliquam non mauris morbi non lectus aliquam sit amet diam in magna bibendum imperdiet nullam orci pede venenatis non', '10:12:44', '2023-05-10', 1, 2);