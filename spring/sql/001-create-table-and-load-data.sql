DROP TABLE IF EXISTS "MasterDuel";

CREATE TABLE September (
  Deck VARCHAR(100) NOT NULL,
  Tier int unsigned NOT NULL,
  PRIMARY KEY(Deck)
);

INSERT INTO September (Deck, Tier) VALUES ('ピュアリィ', 1);
INSERT INTO September (Deck, Tier) VALUES ('スプライト', 2);
INSERT INTO September (Deck, Tier) VALUES ('烙印ビーステッド', 2);
INSERT INTO September (Deck, Tier) VALUES ('ラビュリンス', 2);
INSERT INTO September (Deck, Tier) VALUES ('斬機', 2);


CREATE TABLE November (
  Deck VARCHAR(100) NOT NULL,
  Tier int unsigned NOT NULL,
  PRIMARY KEY(Deck)
);

INSERT INTO November (Deck, Tier) VALUES ('ピュアリィ', 1);
INSERT INTO November (Deck, Tier) VALUES ('斬機', 1);
INSERT INTO November (Deck, Tier) VALUES ('クシャトリラ', 2);
INSERT INTO November (Deck, Tier) VALUES ('ラビュリンス', 2);
INSERT INTO November (Deck, Tier) VALUES ('VS', 2);
