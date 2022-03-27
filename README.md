## Encryption Decryption ##
A Java application that encrypts and decrypts text messages.

-------------

#### Features ####
* Encrypts and decrypts messages using two different algorithms: Caesar and Unicode.
* Messages can be passed through standard input, command line arguments or a text file.
* Output can be displayed with standard output or saved to a txt file on local storage.
* The caesar algorithm changes each character of the message to its corresponding character in the English alphabet and excludes special characters and white space.
* The Unicode algorithm method encrypts or decrypts each
  character of the message according to its number on the Unicode table.
-------------
### Caesar Algorithm ###
#### To Encrypt ####
Original message: For king and country!

Encrypted message: Ktw pnsl fsi htzsywd!
#### To Decrypt ####
Original message: Uqjfxj xjsi mjqu!

Decrypted message: Please send help!

### Unicode Algorithm ###
#### To Encrypt ####
Original message:  All your base belongs to us!

Encrypted message: Fqq%~tzw%gfxj%gjqtslx%yt%zx&

#### To Decrypt ####
Original message: Yfpj%~tzw%knwxy%qjky%ymjs%wnlmy3

Decrypted message: Take your first left then right.

-------------

### How The Application Works ###

* Messages can be  encrypted or decrypted using the Caesar algorithm or the Unicode algorithm via standard input or command line arguments.
* The messages can be read directly from standard input/command line or read from a .txt file.
* To run the application on the command line or standard input use this specific syntax with the arguments. There must be spaces between the different arguments and the 
  message must be within double quotes.

  -key 5 -alg unicode -data "\jqhtrj%yt%m~ujwxpnqq&" -mode dec

* -key is the number of shifts the individual characters will shift, e.g. -key 5 means that the message will shift 5 places. If there is no number supplied then the default 
  argument is 0.
* -mode denotes if the program is encrypting or decrypting a message, e.g. dec is decryption and enc is encryption. If no mode is supplied than the default is encryption.
* -data indicates that messages are read directly from the command line/standard input, e.g. -data "Hello World!". If there is no -data or -in then data is an empty string.
* -in means the program should read the message from a .txt file that is stored in the root directory of the application. If there is no -in then the message is treated as an 
  empty string. If there are both -data and -in arguments than the program will choose -data over -in.
* -out {insert_txt_name_here.txt} will save a new txt file with the encrypted or decrypted method to the root directory of the application. If there is no argument supplied to 
  -out then the program will print the message to standard output.
* Any non-standard situation, such as a file not existing or an argument missing a value, will cause the program to display a clear message about the error.





I choose to make this project to further solidify my knowledge of Java and learn more about command line arguments, Java's file 
package and cryptography. The main challenges I faced while developing this application was accounting for English letters being converted to the corresponding letter in the 
alphabet, e.g. a - z or Y - B. I hope to incorporate other encryption and decryption methods into this application to learn more about cryptography in the future. Below are 
GIF's showing the application being run.