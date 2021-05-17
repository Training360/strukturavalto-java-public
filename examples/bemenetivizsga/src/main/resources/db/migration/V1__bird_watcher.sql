CREATE TABLE IF NOT EXISTS birds_spotted (spotter VARCHAR(255), species VARCHAR(255), date_of_spotting DATE);

INSERT INTO birds_spotted (spotter, species, date_of_spotting) VALUES
                    ('Jane Goldfinch', 'northern cardinal', '2020-05-01'),
                    ('Jack Osprey', 'house sparrow', '2020-04-21'),
                    ('Bill Goshawk', 'house sparrow', '2020-06-05'),
                    ('Bill Goshawk', 'downy woodpecker', '2020-10-01'),
                    ('Jane Goldfinch', 'american robin', '2020-06-05');