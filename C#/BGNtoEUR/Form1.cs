using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace BGNtoEUR
{
    public partial class FormConverter : Form
    {
        private void ConvertCurrency()
        {
            var amountBGN = this.numericUpDownAmount.Value;
            var amountEUR = amountBGN * 1.95583m;
            this.labelResult.Text =
             amountBGN + " BGN = " +
             Math.Round(amountEUR, 2) + " EUR";
        }
        public FormConverter()
        {
            ConvertCurrency();
        }

        private void numericUpDownAmount_ValueChanged
            (object sender, EventArgs e)
        {
            ConvertCurrency();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            ConvertCurrency();
        }
    }
}
