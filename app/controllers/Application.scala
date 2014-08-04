package controllers

import play.api._
import play.api.mvc._

object Application extends Controller {
	// private val items = (1 to 100).toList
	// private val items = (1 to 1000).toList
	// private val items = (1 to 10000).toList
	// private val items = (1 to 100000).toList
	// private val items = (1 to 1000000).toList

	// private val size = stringOfSize(100)
	// private val size = stringOfSize(1000)
	// private val size = stringOfSize(10000)
	// private val size = stringOfSize(100000)
	// private val size = stringOfSize(1000000)
	private val size = stringOfSize(10000000)

	private def stringOfSize(num: Int) = {
		val builder = new StringBuilder(num)
		var i = 0
		while (i < num) {
			builder += 'a'
			i += 1
		}
		builder.toString
	}

	private def time[A](name: String)(cb: => A): A = {
		val start = System.currentTimeMillis
		val ret = cb
		val end = System.currentTimeMillis
		println(name + " took " + (end - start) + "ms")
		ret
	}

	private def doItems(items: List[Int]) = {
		views.xml.number(items)
	}

	private def doString(string: String) = {
		views.xml.string(string)
	}

	def run = Action {
		// time("run") { doItems(items) }
		time("run") { doString(size) }
		Ok("done")
	}

}