import kotlin.math.sqrt

// Класс, представляющий точку на плоскости
data class Point(val x: Double, val y: Double)

fun main() {
    println("Введите количество точек:")
    val pointCount = readLine()?.toIntOrNull()

    if (pointCount == null || pointCount <= 2) {
        println("Количество точек должно быть больше двух!")
        return
    }

    val points = mutableListOf<Point>()

    for (i in 1..pointCount) {
        println("Введите координаты точки $i:")
        val pointString = readLine()
        val coordinates = pointString?.split(" ")

        if (coordinates?.size != 2) {
            println("Некорректные координаты точки!")
            return
        }

        val x = coordinates[0].toDoubleOrNull()
        val y = coordinates[1].toDoubleOrNull()

        if (x == null || y == null) {
            println("Некорректные координаты точки!")
            return
        }

        val point = Point(x, y)
        points.add(point)
    }

    var minDistance = Double.MAX_VALUE
    var maxDistance = 0.0

    for (i in 0 until pointCount - 1) {
        for (j in i + 1 until pointCount) {
            val distance = calculateDistance(points[i], points[j])

            if (distance < minDistance) {
                minDistance = distance
            }

            if (distance > maxDistance) {
                maxDistance = distance
            }
        }
    }

    println("Минимальное расстояние: $minDistance")
    println("Максимальное расстояние: $maxDistance")
}

// Функция для расчета расстояния между двумя точками
fun calculateDistance(point1: Point, point2: Point): Double {
    val dx = point2.x - point1.x
    val dy = point2.y - point1.y
    return sqrt(dx * dx + dy * dy)
}