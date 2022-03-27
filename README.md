## Encryption Decryption ##
A Java application that encrypts and decrypts text messages.

-------------

#### Features ####
* Encrypts and decrypts messages using two different algorithms.
* Messages can be passed through standard input, command line arguments or a text file.
* Output can be displayed with standard output or saved to a txt file on local storage.
* The shift algorithm changes each character of the message to its corresponding character in the English alphabet and excludes special characters and white space.
* The unicode algorithm method encrypts or decrypts each
  character of the message according to its number on the unicode table.
-------------
###Shift Algorithm###
####To Encrypt####
Original message: For king and country!

Encrypted message: Ktw pnsl fsi htzsywd!
####To Decrypt####
Original message: Uqjfxj xjsi mjqu!

Decrypted message: Please send help!

###Unicode Algorithm###
####To Encrypt####
Original message:  All your base belongs to us!

Encrypted message: Fqq%~tzw%gfxj%gjqtslx%yt%zx&

####To Decrypt####
Original message: Yfpj%~tzw%knwxy%qjky%ymjs%wnlmy3

Decrypted message: Take your first left then right.

-------------


###App In Process###

![grab-landing-page](https://github.com/csmithswim/EncryptionDecryption/blob/main/images/dana.gif)





I choose to make this project to further solidify my knowledge of Java and learn more about command line arguments, Java's file 
package and cryptography. The main challenges I faced while developing this application was accounting for English letters being converted to the corresponding letter in the 
alphabet, e.g. a - z or Y - B. I hope to incorporate other encryption and decryption methods into this application to learn more about cryptography in the future. Below are 
GIF's showing the application being run.