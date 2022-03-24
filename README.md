**EncryptionDecryption**
A Java application that encrypts and decrypts text messages.

This Java application can encrypt or decrypt a message taken from standard input, command line arguments or a text file. The output of the application can a standard output or 
saved as a new text file to local storage. There are two specific encryption and decryption methods in the application: shift and unicode. The shift method encrypts or decrypts 
each 
character of the 
message to its corresponding character in the English alphabet and does not pay attention to special characters or white space. The unicode method encrypts or decrypts each 
character of the message according to its number on the unicode table. The two methods work like so:

**The Shift Method**
_To Encrypt_
Original message: For king and country!
Encrypted message: Ktw pnsl fsi htzsywd!
_To Decrypt_
Original message: Uqjfxj xjsi mjqu!
Decrypted message: Please send help!

**The Unicode Method**
_To Encrypt_
Original message:  All your base belongs to us!
Encrypted message: Fqq%~tzw%gfxj%gjqtslx%yt%zx&

_To Decrypt_
Original message: Yfpj%~tzw%knwxy%qjky%ymjs%wnlmy3
Decrypted message: Take your first left then right.



I choose to make this project to further solidify my knowledge of Java and learn more about command line arguments, Java's file 
package and cryptography. The main challenges I faced while developing this application was accounting for English letters being converted to the corresponding letter in the 
alphabet, e.g. a - z or Y - B. I hope to incorporate other encryption and decryption methods into this application to learn more about cryptography in the future. Below are 
GIF's showing the application being run.