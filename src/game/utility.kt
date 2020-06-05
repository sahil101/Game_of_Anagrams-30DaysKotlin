package game
import kotlin.random.Random as r

class utility
{
    var s : String = ""
    var length  : Int  = 0;
    var char_score  =  mutableMapOf<Int, Int>()
    var totalscore  = 0
    constructor( s : String)
    {
        this.s = s
        length = s.length
        char_score = assign_score(s)
    }
    fun shuffling() : String
    {
        var l  = s.toMutableList();
        l.shuffle()
        var str = l.joinToString(separator = "")
        return str
    }
    fun assign_score(s : String) : MutableMap<Int, Int>{
            var score  = mutableMapOf<Int,Int>()
            var char_arr = s.toCharArray()
            for( i in 0..char_arr.size-1)
            {
                val points : Int = r.nextInt(0,char_arr[i].toInt())
                score.put(i,points)
                totalscore = totalscore + points
            }
        return score
    }
}