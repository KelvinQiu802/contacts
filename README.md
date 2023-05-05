# Contacts Javalin

## Database Configuration

1. Create a class called `DBConfig` in `dbconfig` package.
2. Copy all the fields from `DBConfigExample` and replace the placeholders.

## Test

1. Run the `Main` class.
2. Go to `http://localhost:7070/api/contacts`. If you will see following data, congratulations!

```json
[{"name":"John Smith","number":"555-1234"},{"name":"Jane Doe","number":"555-5678"},{"name":"Bob Johnson","number":"555-9012"}]
```

## API Documentation

| HTTP Verbs | Endpoints                     | Action                             | Response Format |
| ---------- | ----------------------------- | ---------------------------------- | --------------- |
| GET        | /api/contacts                 | To retrieve all contacts in the db | JSON            |
| GET        | /api/contacts/{id}            | To retrieve a contact by id        | JSON            |
| POST       | /api/contacts/{name}/{number} | Create a new contact               | Plain Text      |
| DELETE     | /api/contacts/{id}            | Delete a contact                   | Plain Text      |

