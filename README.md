**EncryptionDecryption**
A Java application that encrypts and decrypts text messages.

This Java application can encrypt or decrypt a message taken from standard input, command line arguments or a text file. The output of the application can a standard output or 
saved as a new text file to local storage. There are two specific encryption/decryption methods in the application: shift and unicode. The shift method encrypts or decrypts each 
character of the 
message to its corresponding character in the English alphabet and does not pay attention to special characters or white space. The unicode method encrypts or decrypts each 
character of the message according to its number on the unicode table. The two methods work like so:

**The Shift Method**
To Encrypt:
Original message = For king and country!
Encrypted message = Ktw pnsl fsi htzsywd!
To Decrypt: 
Original message = Uqjfxj xjsi mjqu!
Decrypted message = Please send help!








I choose to make this project to further solidify my knowledge of Java and learn more about command line arguments and Java's file 
package. 
The encryption/decryption methods take a String and a key that allow the message to be encrypted/decrypted by shifting the characters according to their Unicode value.
Two different classes allow two different methodologies to perform the encryption and decryption. Shift simply moves the character ahead in the alphabet while the unicode
class goes ahead with respect to the entire unicode index. This project a part of JetBrains Academy and all solutions and classes are completely unique and written by myself.
