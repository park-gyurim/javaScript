function CheckWeight(name, height, weight) {
    this.userName = name
    this.userHeight = height;
    this.userWeight = weight;
    this.minWeight;
    this.maxWeight;


CheckWeight.prototype.getInfo = function() {
    var str = "";
    str += "나마에와: " + this.userName + ",";
    str += "키:" + this.userHeight + ",";
    str += "몸무게:" + this.userWeight + "<br>";
    return str;
}
CheckWeight.prototype.getResult = function () {
    this.minWeight = (this.userHeight - 100) * 0.9 - 5;
    this.maxWeight = (this.userHeight - 100) * 0.9 + 5;
    if (this.userWeight < this.maxWeight) {
        return "체중미달";
    } else if (this.userWeight > this.maxWeight) {
        return "체중과다";
    } else {
        return "정상체중";
    }
}
}
    var person = new CheckWeight("park", 170, 76);
    var person1 = new CheckWeight("hong", 180, 90);
    console.log(person);
    console.log(person1);
    // console.log(person.getInfo());
    // console.log(person.getResult());
