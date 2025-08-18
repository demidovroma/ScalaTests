db.restaurants.find();
// Отобразите поля идентификатор ресторана, название, район и кухню для всех документов.
db.restaurants.find({}, { restaurant_id: 1, name: 1, borough: 1, cuisine: 1});

// Отобразите поля идентификатор ресторана, название, район и кухню, но исключите поле _id для всех документов.
db.restaurants.find({}, { restaurant_id: 1, name: 1, borough: 1, cuisine: 1, _id: 0});

// Отобразите все рестораны, которые находятся в районе Bronx.
db.restaurants.find({borough: "Bronx"});

// Отобразите следующие 5 ресторанов после пропуска первых 5, которые находятся в районе Bronx.
db.restaurants.find({borough: "Bronx"}).skip(5).limit(5);

// Найдите рестораны, набравшие более 90 баллов.
db.restaurants.find({
        $expr: {
            $and: [
                { $gt: [{ $sum: "$grades.score" }, 90] }
            ]
        }
    },
    {
        _id: 1,
        totalScore: { $sum: "$grades.score" }
    });

// Найдите рестораны, которые набрали более 80, но менее 100 баллов.
db.restaurants.find({
        $expr: {
            $and: [
                { $gt: [{ $sum: "$grades.score" }, 80] },
                { $lt: [{ $sum: "$grades.score" }, 100] }
            ]
        }
    },
    {
        _id: 1,
        totalScore: { $sum: "$grades.score" }
    });

// Найдите рестораны, которые находятся по широте менее -95.754168.
db.restaurants.find({ "address.coord.0": { $lt: -95.754168 } });

// Найдите рестораны, которые не готовят американскую кухню, хотя бы раз набрали более 70 баллов и находятся по широте менее -65,754168.
db.restaurants.find({
    cuisine: { $not: /\bAmerican\b/i },
    "grades.score": { $gt: 70 },
    "address.coord.0": { $lt: -65.754168 }
});

// Найдите рестораны, которые не готовят американскую кухню, набрали хотя бы один раз более 70 баллов и находятся по долготе более 35.754168. Выполните запрос без использования оператора $and.
db.restaurants.find({
    cuisine: { $not: /\bAmerican\b/i },
    "grades.score": { $gt: 70 },
    "address.coord.1": { $gt: 35.754168 }
});

// Найдите рестораны, которые не готовят «американскую» кухню, хотя бы раз получили оценку «А» и не принадлежат району Brooklyn. Документы должны отображаться в соответствии с кухней в порядке убывания.
db.restaurants.find(
    {
        cuisine: { $not: /\bAmerican\b/i },
        "grades.grade": "A",
        borough: { $ne: "Brooklyn" }
    }).sort({ cuisine: -1 })

// Найдите идентификатор ресторана, название, район и кухню для тех ресторанов, которые в качестве первых трех букв в названии ресторана используют «Wil».
db.restaurants.find(
    { name: /^Wil/i },
    { restaurant_id: 1, name: 1, borough: 1, cuisine: 1 }
);

// Найдите рестораны, которые относятся к району Bronx и готовят американские или китайские блюда.
db.restaurants.find(
    {
        borough: "Bronx", // Район Bronx
        cuisine: { $in: [/\bAmerican\b/i, /\bChinese\b/i] }
    }
);

// Найдите идентификатор ресторана, название, район и кухню для тех ресторанов, которые относятся к районам Staten Island, Queens, Bronx или Brooklyn.
db.restaurants.find(
    { borough: { $in: [/\bStaten Island\b/i, /\bQueens\b/i, /\bBronx\b/i, /\bBrooklyn\b/i] }},
    { restaurant_id: 1, name: 1, borough: 1, cuisine: 1 }
);

// Найдите идентификатор ресторана, название, район и кухню для тех ресторанов, которые не относятся к районам Staten Island, Queens, Bronx или Brooklyn.
db.restaurants.find(
    { borough: { $nin: [/\bStaten Island\b/i, /\bQueens\b/i, /\bBronx\b/i, /\bBrooklyn\b/i] }},
    { restaurant_id: 1, name: 1, borough: 1, cuisine: 1 }
);

// Найдите идентификатор ресторана, название, район и кухню для тех ресторанов, которые ни разу не набрали более 10 баллов.
db.restaurants.find(
    { "grades.score": { $not: { $gt: 10 } }},
    { restaurant_id: 1, name: 1, borough: 1, cuisine: 1 }
);

// Найдите идентификатор ресторана, название, район и кухню для тех ресторанов, в которых готовят любую кухню, кроме американской и китайской, или название ресторана начинается с букв «Wil».
db.restaurants.find(
    {
        $or: [
            { cuisine: { $nin: [/\bAmerican\b/i, /\bChinese\b/i] }},
            { name: /^Wil/i}
        ]
    },
    { restaurant_id: 1, name: 1, borough: 1, cuisine: 1 }
);

// Найдите идентификатор ресторана, название и оценки для тех ресторанов, которые достигли оценки «А» и набрали 11 баллов по ISODate «2014-08-11T00:00:00Z».
db.restaurants.find(
    {
        "grades": {
            $elemMatch: {
                grade: "A",
                score: 11,
                date: ISODate("2014-08-11T00:00:00Z")
            }
        }
    },
    { restaurant_id: 1, name: 1, grades: 1 }
);

// Найдите идентификатор ресторана, название и оценки для тех ресторанов, где 2-й элемент массива оценок содержит оценку «А» и набрал 9 баллов по ISODate «2014-08-11T00:00:00Z».
db.restaurants.find(
    {
        "grades.1.grade": "A",
        "grades.1.score": 9,
        "grades.1.date": ISODate("2014-08-11T00:00:00Z")
    },
    { restaurant_id: 1, name: 1, grades: 1 }
);

// Напишите запрос, чтобы расположить название кухни в порядке возрастания, а для этой же кухни район должен быть в порядке убывания.
db.restaurants.find({}).sort({ cuisine: 1, borough: -1 });

// Напишите запрос, чтобы узнать, есть ли рестораны у которых нету улицы. Нужно вывести число таких ресторанов.
db.restaurants.find({ "address.street": { $exists: false } }).count()

db.restaurants.find({ $or: [{ "address.street": { $exists: false } }, { "address.street": "" }]}).count();

// Найдите идентификатор ресторана, название и оценки для тех ресторанов, которые возвращают 0 в качестве остатка после деления баллов на 7.
db.restaurants.find({ "grades.score": { $mod: [7, 0] }},{ restaurant_id: 1, name: 1, grades: 1});

// Напишите запрос, чтобы найти название ресторана, район, координаты и кухню для тех ресторанов, в которых где-то в названии есть последовательность букв «mon».
db.restaurants.find({ name: /mon/i },{ name: 1, borough: 1, coordinates: 1, cuisine: 1 });

// Напишите запрос, чтобы найти название ресторана, район, координаты и кухню для тех ресторанов, в которых первые три буквы названия - «Mad».
db.restaurants.find({ name: /^Mad/i },{ name: 1, borough: 1, coordinates: 1, cuisine: 1 })