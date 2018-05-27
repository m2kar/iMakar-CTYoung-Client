using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace iMakar_CTYoung_Client
{
    public partial class Setting : Form
    {
        public Setting()
        {
            InitializeComponent();
        }

        private void cbArea_SelectedIndexChanged(object sender, EventArgs e)
        {
            Properties.Settings.Default.location = ((ComboBox)sender).Text;
        }

        private void Setting_Load(object sender, EventArgs e)
        {
            
            cbArea.Text = Properties.Settings.Default.location;
        }
    }
}
