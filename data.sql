CREATE DATABASE IF NOT EXISTS test;

use test;

DROP TABLE IF EXISTS book;


CREATE TABLE IF NOT EXISTS book (
  id INT(4) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(100),
  description VARCHAR(255),
  author VARCHAR(100),
  isbn VARCHAR(20),
  printyear INT,
  readalready BOOLEAN,
  INDEX(title)
) engine=InnoDB;


INSERT IGNORE INTO book(id, title, description, author, isbn, printyear, readalready) VALUES (1,
                                                                                              'Genesis',
                                                                                              'In the beginning God created the heaven and the earth. And the earth was without form, and void; and darkness was upon the face of the deep. And the Spirit of God moved upon the face of the waters. God said, Let there be light: and there was light...',
                                                                                              'Holy Spirit',
                                                                                              143952,
                                                                                              2002,
                                                                                              false);
INSERT IGNORE INTO book(id, title, description, author, isbn, printyear, readalready) VALUES (2,
                                                                                              'Exodus',
                                                                                              'And all the souls that came out of the loins of Jacob were seventy souls : for Joseph was in Egypt [already].(loins: Heb. thigh)',
                                                                                              'Holy Spirit',
                                                                                              143953,
                                                                                              2002,
                                                                                              true);
INSERT IGNORE INTO book(id, title, description, author, isbn, printyear, readalready) VALUES (3,
                                                                                              'Leviticus',
                                                                                              'Turn ye not unto idols, nor make to yourselves molten gods: I [am] the LORD your God. And if ye offer a sacrifice of peace offerings unto the LORD, ye shall offer it at your own will. It shall be eaten the same day ye offer it...',
                                                                                              'Holy Spirit',
                                                                                              143954,
                                                                                              2017,
                                                                                              false);
INSERT IGNORE INTO book(id, title, description, author, isbn, printyear, readalready) VALUES (4,
                                                                                              'Numbers',
                                                                                              'Then they shall confess their sin which they have done: and he shall recompense his trespass with the principal thereof, and add unto it the fifth [part] thereof, and give [it] unto [him] against whom he hath trespassed...',
                                                                                              'Holy Spirit',
                                                                                              143955,
                                                                                              2002,
                                                                                              false);
INSERT IGNORE INTO book(id, title, description, author, isbn, printyear, readalready) VALUES (5,
                                                                                              'Deuteronomy',
                                                                                              ' Yahweh said to me, Behold, I have begun to deliver up Sihon and his land before you: begin to possess, that you may inherit his land. Then Sihon came out against us, he and all his people, to battle at Jahaz. Yahweh our God delivered him up before us.',
                                                                                              'Holy Spirit',
                                                                                              143956,
                                                                                              2002,
                                                                                              false);
INSERT IGNORE INTO book(id, title, description, author, isbn, printyear, readalready) VALUES (6,
                                                                                              'Joshua',
                                                                                              'Be strong and of a good courage: for unto this people shalt thou divide for an inheritance the land, which I sware unto their fathers 1 to give them.(or, thou shalt cause this people to inherit the land, etc) Only be thou strong  and very courageous',
                                                                                              'Holy Spirit',
                                                                                              143957,
                                                                                              2017,
                                                                                              false);
INSERT IGNORE INTO book(id, title, description, author, isbn, printyear, readalready) VALUES (7,
                                                                                              'Judges',
                                                                                              'Judah went up; and the LORD delivered the Canaanites and the Perizzites into their hand: and they slew of them in Bezek ten thousand men',
                                                                                              'Holy Spirit',
                                                                                              143958,
                                                                                              2002,
                                                                                              true);
INSERT IGNORE INTO book(id, title, description, author, isbn, printyear, readalready) VALUES (8,
                                                                                              'Ruth',
                                                                                              'Ruth, Intreat me not to leave thee, [or] to return from following after thee: for whither thou goest, I will go; and where thou lodgest, I will lodge: thy people [shall be] my people, and thy God my God:(Intreat…: or, Be not against me)',
                                                                                              'Holy Spirit',
                                                                                              143959,
                                                                                              2002, false);
INSERT IGNORE INTO book(id, title, description, author, isbn, printyear, readalready) VALUES (9,
                                                                                              '1-st book of Samuel',
                                                                                              'She vowed a vow, and said, O LORD of hosts, if thou wilt indeed look on the affliction of thine handmaid, and remember me, and not forget thine handmaid, but wilt give unto thine handmaid a man child, then I will give him unto the LORD all the days',
                                                                                              'Holy Spirit',
                                                                                              143960,
                                                                                              2002,
                                                                                              true);
INSERT IGNORE INTO book(id, title, description, author, isbn, printyear, readalready) VALUES (10,
                                                                                              '2-nd book of Samuel',
                                                                                              'And it came to pass after this, that David enquired of the LORD, saying, Shall I go up into any of the cities of Judah? And the LORD said unto him, Go up. And David said, Whither shall I go up? And he said, Unto Hebron. So David went up...',
                                                                                              'Holy Spirit',
                                                                                              143961,
                                                                                              2002,
                                                                                              true);

INSERT IGNORE INTO book(id, title, description, author, isbn, printyear, readalready) VALUES (11,
                                                                                              '1-st book of Kings',
                                                                                              '..be thou strong therefore, and shew thyself a man; And keep the charge of the LORD thy God, to walk in his ways, to keep his statutes, and his commandments, and his judgments, and his testimonies, as it is written in law of Moses, that u may prosper',
                                                                                              'Holy Spirit',
                                                                                              143962,
                                                                                              2017,
                                                                                              true);
INSERT IGNORE INTO book(id, title, description, author, isbn, printyear, readalready) VALUES (12,
                                                                                              '2-nd book of Kings',
                                                                                              'And the sons of the prophets that [were] at Bethel came forth to Elisha, and said unto him, Knowest thou that the LORD will take away thy master from thy head to day? And he said, Yea, I know [it]; hold ye your peace.',
                                                                                              'Holy Spirit',
                                                                                              143963,
                                                                                              2002,
                                                                                              false);
INSERT IGNORE INTO book(id, title, description, author, isbn, printyear, readalready) VALUES (13,
                                                                                              '1-st book of Chronicles',
                                                                                              ' Then all Israel gathered themselves to David unto Hebron, saying, Behold, we [are] thy bone and thy flesh. And moreover in time past, even when Saul was king, thou [wast] he that leddest out and broughtest in Israel: and the LORD thy God said unto thee',
                                                                                              'Holy Spirit',
                                                                                              143964,
                                                                                              2002,
                                                                                              true);
INSERT IGNORE INTO book(id, title, description, author, isbn, printyear, readalready) VALUES (14,
                                                                                              '2-nd book of Chronicles',
                                                                                              'And Asa did [that which was] good and right in the eyes of the LORD his God: For he took away the altars of the strange [gods], and the high places, and brake down the images, and cut down the groves:(images: Heb. statues)',
                                                                                              'Holy Spirit',
                                                                                              143965,
                                                                                              2002,
                                                                                              false);
INSERT IGNORE INTO book(id, title, description, author, isbn, printyear, readalready) VALUES (15,
                                                                                              'Ezra',
                                                                                              'The LORD God of heaven hath given me all the kingdoms of the earth; and he hath charged me to build him an house at Jerusalem, which [is] in Judah. Who [is there] among you of all his people? his God be with him, and let him go up to Jerusalem',
                                                                                              'Holy Spirit',
                                                                                              143966,
                                                                                              2002,
                                                                                              true);
INSERT IGNORE INTO book(id, title, description, author, isbn, printyear, readalready) VALUES (16,
                                                                                              'Nehemiah',
                                                                                              'But [if] ye turn unto me, and keep my commandments, and do them; though there were of you cast out unto the uttermost part of the heaven, [yet] will I gather them from thence, and will bring them unto the place that I have chosen to set  my name there.',
                                                                                              'Holy Spirit',
                                                                                              143967,
                                                                                              2002,
                                                                                              true);
INSERT IGNORE INTO book(id, title, description, author, isbn, printyear, readalready) VALUES (17,
                                                                                              'Esther',
                                                                                              '..Haman came in. And the king said unto him, What shall be done unto the man whom the king delighteth to honour? Now Haman thought in his heart, To whom would the king delight to do honour more than to myself?(Heb. in whose honour the king delighteth)',
                                                                                              'Holy Spirit',
                                                                                              143968,
                                                                                              2002,
                                                                                              true);
INSERT IGNORE INTO book(id, title, description, author, isbn, printyear, readalready) VALUES (18,
                                                                                              'Job',
                                                                                              'Eliphaz the Temanite and Bildad the Shuhite [and] Zophar the Naamathite went, and did according as the LORD commanded them: the LORD also accepted Job.(Job: Heb. the face of Job) And the LORD turned the captivity of Job, when he prayed for his friends',
                                                                                              'Holy Spirit',
                                                                                              143969,
                                                                                              2017,
                                                                                              true);
INSERT IGNORE INTO book(id, title, description, author, isbn, printyear, readalready) VALUES (19,
                                                                                              'Psalms',
                                                                                              'Out of Zion, the perfection of beauty, God hath shined. Our God shall come, and shall not keep silence: a fire shall devour before him, and it shall be very tempestuous round about him. He shall call to the heavens from above, and to the earth',
                                                                                              'Holy Spirit',
                                                                                              143970,
                                                                                              2002,
                                                                                              true);
INSERT IGNORE INTO book(id, title, description, author, isbn, printyear, readalready) VALUES (20,
                                                                                              'Proverbs',
                                                                                              'For the LORD giveth wisdom: out of his mouth [cometh] knowledge and understanding. He layeth up sound wisdom for the righteous: [he is] a buckler to them that walk uprightly. He keepeth the paths of judgment, and preserveth the way of his saints',
                                                                                              'Holy Spirit',
                                                                                              143971,
                                                                                              2002,
                                                                                              true);

INSERT IGNORE INTO book(id, title, description, author, isbn, printyear, readalready) VALUES (21,
                                                                                              'Ecclesiastes',
                                                                                              'And who knoweth whether he shall be a wise [man] or a fool? yet shall he have rule over all my labour wherein I have laboured, and wherein I have shewed myself wise under the sun. This [is] also vanity...',
                                                                                              'Holy Spirit',
                                                                                              143972,
                                                                                              2002,
                                                                                              false);
INSERT IGNORE INTO book(id, title, description, author, isbn, printyear, readalready) VALUES (22,
                                                                                              'Song of Solomon',
                                                                                              'He brought me to the banqueting house, and his banner over me [was] love.(banqueting…: Heb. house of wine) Stay me with flagons, comfort me with apples: for I [am] sick of love.(comfort…: Heb. straw me with apples',
                                                                                              'Holy Spirit',
                                                                                              143973,
                                                                                              2002,
                                                                                              true);
INSERT IGNORE INTO book(id, title, description, author, isbn, printyear, readalready) VALUES (23,
                                                                                              'Isaiah',
                                                                                              'every one that thirsteth, come ye to the waters, and he that hath no money; come ye, buy, and eat; yea, come, buy wine and milk without money and without price. Wherefore do ye spend money for [that which is] not bread?',
                                                                                              'Holy Spirit',
                                                                                              143974,
                                                                                              2002,
                                                                                              false);
INSERT IGNORE INTO book(id, title, description, author, isbn, printyear, readalready) VALUES (24,
                                                                                              'Jeremiah',
                                                                                              'O thou sword of the LORD, how long [will it be] ere thou be quiet? put up thyself into thy scabbard, rest, and be still.(put…: Heb. gather thyself)',
                                                                                              'Holy Spirit',
                                                                                              143975,
                                                                                              2002,
                                                                                              true);
INSERT IGNORE INTO book(id, title, description, author, isbn, printyear, readalready) VALUES (25,
                                                                                              'Lamentations',
                                                                                              'The elders of the daughter of Zion sit upon the ground, [and] keep silence: they have cast up dust upon their heads; they have girded themselves with sackcloth: the virgins of Jerusalem hang down their heads to the ground.',
                                                                                              'Holy Spirit',
                                                                                              143976,
                                                                                              2002,
                                                                                              true);
INSERT IGNORE INTO book(id, title, description, author, isbn, printyear, readalready) VALUES (26,
                                                                                              'Ezekiel',
                                                                                              'But if the watchman see the sword come, and blow not the trumpet, and the people be not warned; if the sword come, and take [any] person from among them, he is taken away in his iniquity; but his blood will I require at the watchmans hand',
                                                                                              'Holy Spirit',
                                                                                              143977,
                                                                                              2017,
                                                                                              true);
INSERT IGNORE INTO book(id, title, description, author, isbn, printyear, readalready) VALUES (27,
                                                                                              'Daniel',
                                                                                              'Then said Daniel unto the king, O king, live for ever. My God hath sent his angel, and hath shut the lions mouths, that they have not hurt me: forasmuch as before him innocency was found in me; and also before thee, O king, have I done no hurt',
                                                                                              'Holy Spirit',
                                                                                              143978,
                                                                                              2002,
                                                                                              true);
INSERT IGNORE INTO book(id, title, description, author, isbn, printyear, readalready) VALUES (28,
                                                                                              'Hosea',
                                                                                              'Afterward shall the children of Israel return, and seek the LORD their God, and David their king; and shall fear the LORD and his goodness in the latter days',
                                                                                              'Holy Spirit',
                                                                                              143979,
                                                                                              2002,
                                                                                              true);
INSERT IGNORE INTO book(id, title, description, author, isbn, printyear, readalready) VALUES (29,
                                                                                              'Joel',
                                                                                              'I will also gather all nations, and will bring them down into the valley of Jehoshaphat, and will plead with them there for my people and [for] my heritage Israel, whom they have scattered among the nations, and parted my land.',
                                                                                              'Holy Spirit',
                                                                                              143980,
                                                                                              2002,
                                                                                              true);
INSERT IGNORE INTO book(id, title, description, author, isbn, printyear, readalready) VALUES (30,
                                                                                              'Amos',
                                                                                              'Surely the Lord GOD will do nothing, but he revealeth his secret unto his servants the prophets. The lion hath roared, who will not fear? the Lord GOD hath spoken, who can but prophesy?',
                                                                                              'Holy Spirit',
                                                                                              143981,
                                                                                              2002,
                                                                                              true);

INSERT IGNORE INTO book(id, title, description, author, isbn, printyear, readalready) VALUES (31,
                                                                                              'Obadiah',
                                                                                              'u shouldest not have looked on the day of thy brother in the day that he became a stranger; neither shouldest u have rejoiced over the children of Judah in the day of their destruction; neither shouldest u have spoken proudly in the day of distress.',
                                                                                              'Holy Spirit',
                                                                                              143982,
                                                                                              2002,
                                                                                              false);
INSERT IGNORE INTO book(id, title, description, author, isbn, printyear, readalready) VALUES (32,
                                                                                              'Jonah',
                                                                                              'Then Jonah prayed unto the LORD his God out of the fish''s belly, And said, I cried by reason of mine affliction unto the LORD, and he heard me; out of the belly of hell cried I, [and] thou heardest voice.(by…: or, out of mine affliction)',
                                                                                              'Holy Spirit',
                                                                                              143983,
                                                                                              2002,
                                                                                              true);
INSERT IGNORE INTO book(id, title, description, author, isbn, printyear, readalready) VALUES (33,
                                                                                              'Micah',
                                                                                              'For, behold, the LORD cometh forth out of his place, and will come down, and tread upon the high places of the earth',
                                                                                              'Holy Spirit',
                                                                                              143984,
                                                                                              2002,
                                                                                              true);
INSERT IGNORE INTO book(id, title, description, author, isbn, printyear, readalready) VALUES (34,
                                                                                              'Nahum',
                                                                                              'Behold upon the mountains the feet of him that bringeth good tidings, that publisheth peace! O Judah, keep thy solemn feasts, perform thy vows: for the wicked shall no more pass through thee; he is utterly cut off.(keep…: Heb. feast)',
                                                                                              'Holy Spirit',
                                                                                              143985,
                                                                                              2017,
                                                                                              true);
INSERT IGNORE INTO book(id, title, description, author, isbn, printyear, readalready) VALUES (35,
                                                                                              'Habakkuh',
                                                                                              'I''ll stand upon my watch, and set me upon the tower, and will watch to see what he will say unto me, and what I shall answer when I am reproved.(tower: Heb. fenced place)(unto me: or, in me)',
                                                                                              'Holy Spirit',
                                                                                              143986,
                                                                                              2002,
                                                                                              true);
INSERT IGNORE INTO book(id, title, description, author, isbn, printyear, readalready) VALUES (36,
                                                                                              'Zephaniah',
                                                                                              'Seek ye the LORD, all ye meek of the earth, which have wrought his judgment; seek righteousness, seek meekness: it may be ye shall be hid in the day of the LORD''S anger.',
                                                                                              'Holy Spirit',
                                                                                              143987,
                                                                                              2002,
                                                                                              true);
INSERT IGNORE INTO book(id, title, description, author, isbn, printyear, readalready) VALUES (37,
                                                                                              'Haggai',
                                                                                              'Yet now be strong, O Zerubbabel, saith the LORD; and be strong, O Joshua, son of Josedech, the high priest; and be strong, all ye people of the land, saith the LORD, and work: for I [am] with you, saith the LORD of hosts',
                                                                                              'Holy Spirit',
                                                                                              143988,
                                                                                              2002,
                                                                                              false);
INSERT IGNORE INTO book(id, title, description, author, isbn, printyear, readalready) VALUES (38,
                                                                                              'Zechariah',
                                                                                              'angel that talked with me went forth, and another angel went out to meet him, And said unto him, Run, speak to this young man, saying, Jerusalem shall be inhabited [as] towns without walls for the multitude of men and cattle therein',
                                                                                              'Holy Spirit',
                                                                                              143989,
                                                                                              2002,
                                                                                              true);
INSERT IGNORE INTO book(id, title, description, author, isbn, printyear, readalready) VALUES (39,
                                                                                              'Malachi',
                                                                                              'And now, O ye priests, this commandment [is] for you. If ye will not hear, and if ye will not lay [it] to heart, to give glory unto my name, saith the LORD of hosts, I will even send a curse upon you, and I will curse your blessings...',
                                                                                              'Holy Spirit',
                                                                                              143990,
                                                                                              2002,
                                                                                              false);
INSERT IGNORE INTO book(id, title, description, author, isbn, printyear, readalready) VALUES (40,
                                                                                              'New Testament',
                                                                                              'I''ve given to them words which u gavest me; and they''ve received [them], and have known surely that I came out from thee, and they have believed that u didst send me. I pray for them: I pray not for world, but for them which u hast given me',
                                                                                              'Holy Spirit',
                                                                                              143991,
                                                                                              2017,
                                                                                              true);


CREATE TABLE IF NOT EXISTS pagetypes (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(80),
  INDEX(name)
) engine=InnoDB;

INSERT IGNORE INTO pagetypes VALUES (1, 'plain old text');
INSERT IGNORE INTO pagetypes VALUES (2, 'XHTML');
INSERT IGNORE INTO pagetypes VALUES (3, 'java');
INSERT IGNORE INTO pagetypes VALUES (4, 'javascript');
INSERT IGNORE INTO pagetypes VALUES (5, 'scala');
INSERT IGNORE INTO pagetypes VALUES (6, 'alive fresh flow');



CREATE TABLE IF NOT EXISTS pages (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(80),
  writtendate DATE,
  bookid INT(10),
  pagetype INT(10),

  INDEX(name)
) engine=InnoDB;

INSERT IGNORE INTO pages(id, name, writtendate, bookid, pagetype) VALUES (1,
                                                                          'page1',
                                                                          '2018-01-10',
                                                                          3,
                                                                          6);
INSERT IGNORE INTO pages(id, name, writtendate, bookid, pagetype) VALUES (2,
                                                                          'page2',
                                                                          '2018-02-01',
                                                                          3,
                                                                          2);
INSERT IGNORE INTO pages(id, name, writtendate, bookid, pagetype) VALUES (3,
                                                                          'page3',
                                                                          '2018-02-03',
                                                                          3,
                                                                          1);
INSERT IGNORE INTO pages(id, name, writtendate, bookid, pagetype) VALUES (4,
                                                                          'page1',
                                                                          '2018-02-07',
                                                                          4,
                                                                          5);


CREATE TABLE IF NOT EXISTS remarks (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  date DATE,
  description VARCHAR(255),
  pageid INT(10),
  INDEX(pageid)
) engine=InnoDB;

INSERT IGNORE INTO remarks(id, date, description, pageid) VALUES (1,
                                                                  '2018-02-13',
                                                                  'When you reap the harvest of your land, do not reap to the very edges of your field or gather the gleanings of your harvest. Do not go over your vineyard a second time or pick up the grapes that have fallen',
                                                                  1);
INSERT IGNORE INTO remarks(id, date, description, pageid) VALUES (2,
                                                                  '2018-07-10',
                                                                  'Leave them for the poor and the foreigner. I am the Lord your God.',
                                                                  1);
INSERT IGNORE INTO remarks(id, date, description, pageid) VALUES (3,
                                                                  '2018-07-05',
                                                                  'Do not swear falsely by my name and so profane the name of your God. I am the Lord. Do not defraud or rob your neighbor. Do not hold back the wages of a hired worker overnight.',
                                                                  1);
INSERT IGNORE INTO remarks(id, date, description, pageid) VALUES (4,
                                                                  '2018-10-31',
                                                                  'Do not pervert justice; do not show partiality to the poor or favoritism to the great, but judge your neighbor fairly. Do not go about spreading slander among your people.',
                                                                  2);
INSERT IGNORE INTO remarks(id, date, description, pageid) VALUES (5,
                                                                  '2018-11-01',
                                                                  'Do not do anything that endangers your neighbor’s life. I am the Lord.',
                                                                  2);
INSERT IGNORE INTO remarks(id, date, description, pageid) VALUES (6,
                                                                  '2018-11-03',
                                                                  'Do not hate a fellow Israelite in your heart. Rebuke your neighbor frankly so you will not share in their guilt',
                                                                  2);
INSERT IGNORE INTO remarks(id, date, description, pageid) VALUES (7,
                                                                  '2018-11-07',
                                                                  'Do not seek revenge or bear a grudge against anyone among your people, but love your neighbor as yourself. I am the Lord.',
                                                                  2);
INSERT IGNORE INTO remarks(id, date, description, pageid) VALUES (8,
                                                                  '2018-11-11',
                                                                  'Do not practice divination or seek omens.. Do not turn to mediums or seek out spiritists, for you will be defiled by them. I am the Lord your God.',
                                                                  3);
INSERT IGNORE INTO remarks(id, date, description, pageid) VALUES (9,
                                                                  '2018-11-12',
                                                                  'Stand up in the presence of the aged, show respect for the elderly and revere your God. I am the Lord.',
                                                                  3);
INSERT IGNORE INTO remarks(id, date, description, pageid) VALUES (10,
                                                                  '2018-11-13',
                                                                  'When a foreigner resides among you in your land, do not mistreat them. The foreigner residing among you must be treated as your native-born. Love them as yourself, for you were foreigners in Egypt. I am the Lord your God',
                                                                  3);
INSERT IGNORE INTO remarks(id, date, description, pageid) VALUES (11,
                                                                  '2018-11-14',
                                                                  'Do not use dishonest standards when measuring length, weight or quantity. Use honest scales and honest weights, an honest ephah[d] and an honest hin.[e] I am the Lord your God, who brought you out of Egypt.',
                                                                  3);
INSERT IGNORE INTO remarks(id, date, description, pageid) VALUES (12,
                                                                  '2018-12-02',
                                                                  'Command the People of Israel to ban from the camp anyone who has an infectious skin disease, anyone who has a discharge, and anyone who is ritually unclean from contact with a dead body. Ban male and female alike; send them outside the camp so that they won’t defile their camp, the place I live among them',
                                                                  4);
INSERT IGNORE INTO remarks(id, date, description, pageid) VALUES (13,
                                                                  '2018-12-03',
                                                                  'When Moses sent them off to scout out Canaan, he said, “Go up through the Negev and then into the hill country. Look the land over, see what it is like. Assess the people: Are they strong or weak? Are there few or many? Observe the land: Is it pleasant?',
                                                                  4);
INSERT IGNORE INTO remarks(id, date, description, pageid) VALUES (14,
                                                                  '2018-12-09',
                                                                  'We went to the land to which you sent us and, oh! It does flow with milk and honey! Just look at this fruit! The only thing is that the people who live there are fierce, their cities are huge and well fortified.',
                                                                  4);