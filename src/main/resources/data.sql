insert into genre(name) values('Male');
insert into genre(name) values('Female');
insert into genre(name) values('Fluid');
insert into genre(name) values('Other');

insert into person(first_name, last_name, dni, age, id_genre, status, drives, glasses, diabetic, other_disease, disease)
values('Emanuel', 'Also', 35568892, 31, 1, true, true, true, false, false, null);
insert into person(first_name, last_name, dni, age, id_genre, status, drives, glasses, diabetic, other_disease, disease)
values('Mariel', 'Calhuante', 37160702, 28, 2, true, false, true, false, false, null);
insert into person(first_name, last_name, dni, age, id_genre, status, drives, glasses, diabetic, other_disease, disease)
values('Aguero', 'Sergio', 3413712, 33, 1, false, true, false, false, true, "Arritmia");
insert into person(first_name, last_name, dni, age, id_genre, status, drives, glasses, diabetic, other_disease, disease)
values('Lionel', 'Messi', 37684798, 34, 1, true, true, false, false, false, null);