using System;
using System.Collections.Generic;
using System.Linq;

namespace Objects_Classes_MoreExercises_03._Jarvis
{
    class Jarvis
    {
        public Head Head { get; set; }
        public  Torso Torso { get; set; }
        public List<Arm> Arms { get; set; }
        public List<Leg> Legs { get; set; }

        public Jarvis(Head head, Torso torso, List<Arm> arms, List<Leg> legs)
        {
            Head = head;
            Torso = torso;
            Arms = arms;
            Legs = legs;
        }

        public bool HaveAllParts
        {
            get
            {
                return (Head.EnergyConsumprion != int.MaxValue
                    && Torso.EnergyConsumprion != int.MaxValue
                    && Arms.Count == 2 
                    && Legs.Count == 2)
                    ? true : false;
            }
        }
        public int ArmsEnergy
        {
            get
            {
                var sumEnergy = 0;
                foreach (var arm in Arms)
                {
                    sumEnergy += arm.EnergyConsumprion;
                }
                return sumEnergy;
            }
        }
        public int LegsEnergy
        {
            get
            {
                var sumEnergy = 0;
                foreach (var leg in Legs)
                {
                    sumEnergy += leg.EnergyConsumprion;
                }
                return sumEnergy;
            }
        }
        public long neededEnergy
        {
            get
            {
                return Head.EnergyConsumprion + Torso.EnergyConsumprion +
                    ArmsEnergy + LegsEnergy;
            }
        }
    }
    class Head
    {
        public int EnergyConsumprion { get; set; } = int.MaxValue;
        public int IQ { get; set; }
        public string SkinMaterial { get; set; }

        public void PrintHead()
        {
            Console.WriteLine("#Head:");
            Console.WriteLine($"###Energy consumption: {EnergyConsumprion}");
            Console.WriteLine($"###IQ: {IQ}");
            Console.WriteLine($"###Skin material: {SkinMaterial}");
        }
    }
    class Torso
    {
        public int EnergyConsumprion { get; set; } = int.MaxValue;
        public double ProcesirSize { get; set; }
        public string CorpusMaterial { get; set; }

        public void PrintTorso()
        {
            Console.WriteLine("#Torso:");
            Console.WriteLine($"###Energy consumption: {EnergyConsumprion}");
            Console.WriteLine($"###Processor size: {ProcesirSize:f1}");
            Console.WriteLine($"###Corpus material: {CorpusMaterial}");
        }
    }
    class Arm
    {
        public int EnergyConsumprion { get; set; } = int.MaxValue;
        public int Reach { get; set; }
        public int Fingers { get; set; }

        public void PrintArm()
        {
            Console.WriteLine("#Arm:");
            Console.WriteLine($"###Energy consumption: {EnergyConsumprion}");
            Console.WriteLine($"###Reach: {Reach}");
            Console.WriteLine($"###Fingers: {Fingers}");
        }
    }
    class Leg
    {
        public int EnergyConsumprion { get; set; } = int.MaxValue;
        public int Strength { get; set; }
        public int Speed { get; set; }

        public void PrintLeg()
        {
            Console.WriteLine("#Leg:");
            Console.WriteLine($"###Energy consumption: {EnergyConsumprion}");
            Console.WriteLine($"###Strength: {Strength}");
            Console.WriteLine($"###Speed: {Speed}");
        }
    }
    class Program
    {
        static void Main(string[] args)
        {
            List<Head> heads = new List<Head>();
            List<Torso> torsos = new List<Torso>();
            List<Arm> arms = new List<Arm>();
            List<Leg> legs = new List<Leg>();
            long givenEnergy = long.Parse(Console.ReadLine());

            string input = Console.ReadLine();

            while (input != "Assemble!")
            {
                string[] commands = input
                    .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries);
                switch (commands[0])
                {
                    case "Head":
                        Head current = new Head()
                        {
                            EnergyConsumprion = int.Parse(commands[1]),
                            IQ = int.Parse(commands[2]),
                            SkinMaterial = commands[3]
                        };
                        heads.Add(current);
                        break;
                    case "Torso":
                        Torso curr = new Torso()
                        {
                            EnergyConsumprion = int.Parse(commands[1]),
                            ProcesirSize = int.Parse(commands[2]),
                            CorpusMaterial = commands[3]
                        };
                        torsos.Add(curr);
                        break;
                    case "Arm":
                        Arm currArm = new Arm()
                        {
                            EnergyConsumprion = int.Parse(commands[1]),
                            Reach = int.Parse(commands[2]),
                            Fingers = int.Parse(commands[3])
                        };
                        arms.Add(currArm);
                        break;
                    case "Leg":
                        Leg currLeg = new Leg()
                        {
                            EnergyConsumprion = int.Parse(commands[1]),
                            Strength = int.Parse(commands[2]),
                            Speed = int.Parse(commands[3])
                        };
                        legs.Add(currLeg);
                        break;
                }
                input = Console.ReadLine();
            }
            var bestEnergy = int.MaxValue;
            Head bestHead = new Head();
            foreach (var h in heads)
            {
                if (h.EnergyConsumprion < bestEnergy)
                {
                    bestEnergy = h.EnergyConsumprion;
                    bestHead = h;
                }
            }

            Torso bestTorso = new Torso();
             bestEnergy = int.MaxValue;
            foreach (var t in torsos)
            {
                if (t.EnergyConsumprion < bestEnergy)
                {
                    bestEnergy = t.EnergyConsumprion;
                    bestTorso = t;
                }
            }

            var bestArms = arms.OrderBy(x => x.EnergyConsumprion).Take(2).ToList();
            var bestLegs = legs.OrderBy(x => x.EnergyConsumprion).Take(2).ToList();
            var jar = new Jarvis(bestHead,bestTorso,bestArms,bestLegs);
            if (!jar.HaveAllParts)
            {
                Console.WriteLine("We need more parts!");
            }
            else if (jar.neededEnergy > givenEnergy)
            {
                Console.WriteLine("We need more power!");
            }
            else
            {
                Console.WriteLine("Jarvis:");
                jar.Head.PrintHead();
                jar.Torso.PrintTorso();
                foreach (var arm in jar.Arms)
                {
                    arm.PrintArm();
                }
                foreach (var leg in jar.Legs)
                {
                    leg.PrintLeg();
                }
            }
        }
    }
}
