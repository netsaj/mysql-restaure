# mysql-restaure

Utility to restore long .sql files.
If the connection to the server is lost, keep trying until the sentence is completed.

In each insertion, keep a control point, in case of closing back to the last point where the pointer was.

## Authors

* Fabio Moreno <fabiomoreno@outlook.com>