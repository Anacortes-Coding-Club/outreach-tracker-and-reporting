const fs = require("fs");

// deserialize
const filename = "visits_js.json";
const json = fs.readFileSync(filename, "utf8");
const visits = JSON.parse(json);
console.log("Read visits:", visits.length);

const days = new Set();
let earliest, latest;
for (const visit of visits) {
  days.add(visit.date);
  if (!earliest || visit.date < earliest) {
    earliest = visit.date;
  }
  if (!latest || visit.date > latest) {
    latest = visit.date;
  }
}
console.log(
  days.size,
  "outreach service days",
  `between ${earliest} and ${latest}`
);

const clientMap = new Map();
for (const visit of visits) {
  for (const name of visit.name) {
    if (!clientMap.has(name)) {
      clientMap.set(name, []);
    }
    clientMap.get(name).push(visit);
  }
}
console.log(clientMap.size + " distinct clients served");
