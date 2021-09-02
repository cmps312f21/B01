package cmps312.lab.books.model

//class like java

open class Book(var name: String, var author: String, val yearOfPublication: Int) {
    override fun toString(): String {
        return """
            Name : $name
            Author : $author
            Year of publication : $yearOfPublication
        """
    }
}

// ctrl + alt + l
// cmnd + option + l
class AudioBook(
    name: String,
    author: String,
    yearOfPublication: Int,
    var size: Int,
    var length: Int,
    var artistName: String) : Book(name, author, yearOfPublication) {

    override fun toString(): String {
        return """
            ${super.toString()}
            Size : $size
            Length : $length
            Artist Name : $artistName
        """.trimIndent()
    }
}
class PaperBook(
    name: String,
    author: String,
    yearOfPublication: Int,
    var publisher: String,
    var isbn: String) : Book(name, author, yearOfPublication) {

    override fun toString(): String {
        return """
            ${super.toString()}
            Publisher : $publisher
            isbn : $isbn
        """.trimIndent()
    }
}

fun main() {
    val book = Book("Loard of the rings", "J.R.R", 1954)

    val audioBook1 = AudioBook("Loard of the rings V1 ", "J.R.R", 1954, 12, 300, "Yousseif Elshahawy")
    val audioBook2 = AudioBook("Loard of the rings V2 ", "J.R.R", 1955, 12, 300, "Yousseif Elshahawy")
    val audioBook3 = AudioBook("Loard of the rings V3", "J.R.R", 1956, 12, 300, "Yousseif Elshahawy")

    val paperBook1 = PaperBook("Loard of the rings V1 ", "J.R.R", 1941, "Oriely1", "22-333-44-55")
    val paperBook2 = PaperBook("Loard of the rings V2 ", "J.R.R", 1954, "Oriely2", "223-33-44-55")
    val paperBook3 = PaperBook("Loard of the rings V3",  "J.R.R", 1954, "Oriely3", "223-33-44-55")


    val books = mutableListOf(paperBook1, audioBook1, audioBook2 , paperBook2 , audioBook3 , paperBook3)
    for (book in books)
        println(book)

}