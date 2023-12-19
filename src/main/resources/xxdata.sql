INSERT INTO TITULO (dtype, id, isbn, num_reserva, titulo)
VALUES ('titulo', 1, '123-4', 'R1-5', 'Primer titulo'),
       ('titulo', 2, '222-2', 'R2-2', 'Segundo titulo');

INSERT INTO EJEMPLAR (titulo_id) VALUES (1), (1), (1), (2), (2);

INSERT INTO USUARIO (nombre, apellidos) VALUES ('Paco', 'Santana');