INSERT INTO client (id, name, type) VALUES
      (1, 'David Grosman', 'a'),
      (2, 'Meir Shalev', 'a'),
      (3, 'Yehuda Amichai', 'b'),
      (4, 'Dan Brown', 'b');

INSERT INTO client_movie (client_movie_id, client_id, movie_id, rating) VALUES
    (1, 1, 1, 1),
    (2, 2, 1, 5),
    (3, 1, 2, 5),
    (4, 2, 2, 1);

--
--INSERT INTO user (id, active, password, roles, userName) VALUES
--    (1, 'true', 'pass', 'ADMIN', 'admin1'),
--    (2, 'true', 'pass', 'ADMIN', 'admin2'),
--    (3, 'true', 'pass', 'USER', 'user1'),
--    (4, 'true', 'pass', 'USER', 'user2');







