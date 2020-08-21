Hi and welcome!

This repository shows how to express SQL commands in pure Java:
1. USE database1;
2. SELECT id, name, address FROM users WHERE is_customer IS NOT NULL ORDER BY created;
3. INSERT INTO user_notes (id, user_id, note, created) VALUES (1, 1, "Note 1", NOW());
4. DELETE FROM database2.logs WHERE id < 1000;

Techniques and tools used:
1. Collections 
2. Streams
3. Predicates
4. Builder pattern
5. Git version control system
