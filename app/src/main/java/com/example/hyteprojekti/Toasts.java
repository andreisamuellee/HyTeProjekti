package com.example.hyteprojekti;

import java.util.Random;

public class Toasts {
    String[] randomToasts;

    Toasts() {
        randomToasts = new String[]{"There are 1.1 billion smokers.", "Smoking is the cause of 1 in 5 deaths.", "The majority of smokers are within the age 20-32.",
                "A single cigarette contains over 4,800 chemicals.", "Smoking increases your risk of getting lung diseases.",
                "Tobacco kills up to half of its users.", "Tobacco kills more than 8 million people each year.", "Passive smoking is a cause of bronchitis.",
                "Second-hand smoke causes 1.2 million premature deaths per year.", "Adult male smokers lose an average of 13.2 years of life.",
                "Around 10 million cigarettes are purchased per minute.", "There are more than 4,000 chemicals in tobacco smoke.",
                "Second hand smoking kills.", "There is no safe level of exposure to secondhand smoke.", "Smoking is irritation to the eyes, nose, throat.",
                "Tobacco contains arsenic.", "Tobacco contains cyanide.", "Ninety percent of lung cancer cases are due to smoking.",
                "Smoking raises blood pressure.", "Smoking stains your teeth and gums.", "Life insurance is more expensive.", "Around 120,000 men in the UK are impotent as a result of smoking.",
                "Smoking is expensive.", "Smokers age quicker than non smokers.", "Smoking worsens asthma.", "Increased risk of sudden infant death syndrome.",
                "Your sense of taste and smell are dulled.", "Smoking causes 27% higher chance of a miscarriage.", "Smoking is the main cause of Chronic Obstructive Pulmonary Disease.",
                "Smokers are twice as likely to experience premature labour.", "Men who smoke have a lower sperm count than non-smokers.",
                "The Peruvian Aguaruna aboriginals would make hallucinogenic enemas using tobacco.", "Currently, over 5.5 trillion cigarettes are produced globally per year.",
                "Ambergris (whale vomit) has been added to cigarettes for flavor.", "Smoking damages your heart and your blood circulation.", "Your lungs can be very badly affected by smoking.",
                "Increased risk of cancer in your lips, tongue and throat.", "Smokers have an increased chance of getting stomach cancer.", "If you smoke, you are more likely to have a stroke.",
                "Smoking reduces the amount of oxygen that gets to your skin.", "Smoking can cause your bones to become weak and brittle.", "Smoking makes your heart work harder than normal.",
                "Smoking makes your blood thicker.", "Smoking narrows your arteries.", "Smoking clots your arteries.", "Higher change of brain aneurysm.",
                "More than 93% of oropharyngeal cancers are caused by smoking.", "Smoking prematurely ages your skin by between 10 and 20 years.", "Smoking can cause male impotence.",
                "Smoking causes testicular cancer.", "Average smoker spends 1500eur a year on tobacco.", "It's completely legal for minors to smoke cigarettes."};
    }

    public String toString() {
        return randomToasts[new Random().nextInt(randomToasts.length - 1)];
    }
}
