Telephone
=========

Given a list of phone numbers, determine if it is consistent. In a
consistent phone list no number is a prefix of another. For example:

* Bob: 91125426
* Alice: 97 625 992
* Emergency: 911

In this case, it is not possible to call Bob because the phone
exchange would direct your call to the emergency line as soon as you
dialled the first three digits of Bob’s phone number. So this list
would not be consistent.

The input to your system will be a map of name to phone number.  Names
therefore cannot repeat (i.e. you don't have to deal with
disambiguation).

Extensions
----------

Report back which entries are in conflict: "Bob @ 91125426" is unreachable 
because of "Emergency @ 911"

Add the ability to parse the phone number list from a text file in
`<name> : <number>` form

Credit
------

Cribbed from Emily Bache's "Coding Dojo Handbook"
