-- noinspection SqlNoDataSourceInspectionForFile
-- Planets
  insert into planet(name,rotation_period,orbital_period,diameter,climate,gravity,terrain,surface_water,population) values ('Alderaan',24,24,12500,'temperate','1 standard','grasslands, mountains',40,2000000000)
  insert into planet(name,rotation_period,orbital_period,diameter,climate,gravity,terrain,surface_water,population) values ('Yavin IV',24,4818,10200,'temperate, tropical','1 standard','jungle, rainforest',8,1000)
  insert into planet(name,rotation_period,orbital_period,diameter,climate,gravity,terrain,surface_water,population) values ('Hoth',23,549,7200,'frozen','1.1 standard','tundra, ice caves, mountain ranges',100,-1)
  insert into planet(name,rotation_period,orbital_period,diameter,climate,gravity,terrain,surface_water,population) values ('Dagobah',23,341,8900,'murky','N/A','swamp, jungles',8,-1)
  insert into planet(name,rotation_period,orbital_period,diameter,climate,gravity,terrain,surface_water,population) values ('Bespin',12,5110,118000,'temperate','1.5 (surface), 1 standard (Cloud City)','gas giant',0,6000000)
  insert into planet(name,rotation_period,orbital_period,diameter,climate,gravity,terrain,surface_water,population) values ('Endor',18,402,4900,'temperate','0.85 standard','forests, mountains, lakes',8,30000000)

-- People
  insert into people(name,birth_year,gender,height,mass,eye_color,hair_color,skin_color) values ('Luke Skywalker','19BBY','Male','1.72 m','77 Kg','Blue','Blond','Caucasian')
  insert into people(name,birth_year,gender,height,mass,eye_color,hair_color,skin_color) values ('R2-D2','112BBY','n/a','167','75','yellow','n/a','gold')
  insert into people(name,birth_year,gender,height,mass,eye_color,hair_color,skin_color) values ('C-3PO','33BBY','n/a','96','32','red','n/a','white, blue')
  insert into people(name,birth_year,gender,height,mass,eye_color,hair_color,skin_color) values ('Darth Vader','41.9BBY','male','202','136','red','none', 'white')

-- Film
  insert into film(title,episode_id,opening_crawl,director,producer,release_date) values ('The Phantom Menace',1,'Turmoil has engulfed the Galactic Republic. The taxation of trade routes to outlying star systems is in dispute. Hoping to resolve the matter with a blockade of deadly battleships, the greedy Trade Federation has stopped all shipping to the small planet of Naboo. While the Congress of the Republic endlessly debates this alarming chain of events, the Supreme Chancellor has secretly dispatched two Jedi Knights, the guardians of peace and justice in the galaxy, to settle the conflict....','George Lucas','Rick McCallum',TO_DATE('1999/05/19', 'YYYY/MM/DD'))
  insert into film(title,episode_id,opening_crawl,director,producer,release_date) values ('Attack of the Clones',2,'There is unrest in the Galactic Senate. Several thousand solar systems have declared their intentions to leave the Republic. This separatist movement, under the leadership of the mysterious Count Dooku, has made it difficult for the limited number of Jedi Knights to maintain peace and order in the galaxy. Senator Amidala, the former Queen of Naboo, is returning to the Galactic Senate to vote on the critical issue of creating an ARMY OF THE REPUBLIC to assist the overwhelmed Jedi....','George Lucas','Rick McCallum',TO_DATE('2002/05/16', 'YYYY/MM/DD'))
  insert into film(title,episode_id,opening_crawl,director,producer,release_date) values ('Revenge of the Sith',3,'War! The Republic is crumbling under attacks by the ruthless Sith Lord, Count Dooku. There are heroes on both sides. Evil is everywhere. In a stunning move, the fiendish droid leader, General Grievous, has swept into the Republic capital and kidnapped Chancellor Palpatine, leader of the Galactic Senate. As the Separatist Droid Army attempts to flee the besieged capital with their valuable hostage, two Jedi Knights lead a desperate mission to rescue the captive Chancellor....','George Lucas','Rick McCallum',TO_DATE('2005/05/19', 'YYYY/MM/DD'))
  insert into film(title,episode_id,opening_crawl,director,producer,release_date) values ('A New Hope',4,'It is a period of civil war. Rebel spaceships, striking from a hidden base, have won their first victory against the evil Galactic Empire. During the battle, Rebel spies managed to steal secret plans to the Empire''s ultimate weapon, the DEATH STAR, an armored space station with enough power to destroy an entire planet. Pursued by the Empire''s sinister agents, Princess Leia races home aboard her starship, custodian of the stolen plans that can save her people and restore freedom to the galaxy....','George Lucas','Gary Kurtz, Rick McCallum',TO_DATE('1977/05/25', 'YYYY/MM/DD'))
  insert into film(title,episode_id,opening_crawl,director,producer,release_date) values ('The Empire Strikes Back',5,'It is a dark time for the Rebellion. Although the Death Star has been destroyed, Imperial troops have driven the Rebel forces from their hidden base and pursued them across the galaxy. Evading the dreaded Imperial Starfleet, a group of freedom fighters led by Luke Skywalker has established a new secret base on the remote ice world of Hoth. The evil lord Darth Vader, obsessed with finding young Skywalker, has dispatched thousands of remote probes into the far reaches of space....','Irvin Kershner','Gary Kutz, Rick McCallum',TO_DATE('1980/05/17', 'YYYY/MM/DD'))
  insert into film(title,episode_id,opening_crawl,director,producer,release_date) values ('Return of the Jedi',6,'Luke Skywalker has returned to his home planet of Tatooine in an attempt to rescue his friend Han Solo from the clutches of the vile gangster Jabba the Hutt. Little does Luke know that the GALACTIC EMPIRE has secretly begun construction on a new armored space station even more powerful than the first dreaded Death Star. When completed, this ultimate weapon will spell certain doom for the small band of rebels struggling to restore freedom to the galaxy...','Richard Marquand','Howard G. Kazanjian, George Lucas, Rick McCallum',TO_DATE('1983/05/25', 'YYYY/MM/DD'))
  insert into film(title,episode_id,opening_crawl,director,producer,release_date) values ('The Force Awakens',7,'Luke Skywalker has vanished. In his absence, the sinister FIRST ORDER has risen from the ashes of the Empire and will not rest until Skywalker, the last Jedi, has been destroyed. With the support of the REPUBLIC, General Leia Organa leads a brave RESISTANCE. She is desperate to find her brother Luke and gain his help in restoring peace and justice to the galaxy. Leia has sent her most daring pilot on a secret mission to Jakku, where an old ally has discovered a clue to Luke''s whereabouts....','J. J. Abrams','Kathleen Kennedy, J. J. Abrams, Bryan Burk',TO_DATE('2015/12/11', 'YYYY/MM/DD'))

-- Planets per film
  insert into film_planets (film_id, planet_id) values (1, 6)
  insert into film_planets (film_id, planet_id) values (1, 2)
  insert into film_planets (film_id, planet_id) values (2, 1)
  insert into film_planets (film_id, planet_id) values (3, 3)
  insert into film_planets (film_id, planet_id) values (4, 2)
  insert into film_planets (film_id, planet_id) values (4, 5)
  insert into film_planets (film_id, planet_id) values (4, 6)
  insert into film_planets (film_id, planet_id) values (5, 3)
  insert into film_planets (film_id, planet_id) values (6, 4)
  insert into film_planets (film_id, planet_id) values (6, 5)
  insert into film_planets (film_id, planet_id) values (7, 6)

-- People per Film
  insert into film_people (film_id, people_id) values (1,1)
  insert into film_people (film_id, people_id) values (1,2)
  insert into film_people (film_id, people_id) values (1,3)
  insert into film_people (film_id, people_id) values (1,4)
  insert into film_people (film_id, people_id) values (2,1)
  insert into film_people (film_id, people_id) values (2,2)
  insert into film_people (film_id, people_id) values (2,4)