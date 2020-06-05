package game
import java.io.File
import kotlin.random.Random as r
//file handling
class filehandle() {
    var arr = mutableListOf<String>()
    var filename : String = ""
    constructor(filename : String):this()
    {
        this.filename = filename
    }
    fun reading()
    {   val file = File(filename)
        val bufferedReader = file.bufferedReader()
        val text = bufferedReader.readLines()
        for(line in text){
            var l = line.split("\n").toList()
            for(i in 0..l.size-1) {
                arr.add(l[i])
            }
        }
    }
    fun generate() : List<String>{
        var words  = mutableListOf<String>()
        for(i in 0..9) {
            var rand = r.nextInt(0, arr.size-1)
            words.add(arr[rand])
        }
        return words
    }
}